package com.thtns.car.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCard;
import com.thtns.car.entity.BizMember;
import com.thtns.car.entity.BizTransactionRecord;
import com.thtns.car.enums.CardTypeEnum;
import com.thtns.car.mapper.BizMemberMapper;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.UpdateBizMemberRequest;
import com.thtns.car.service.IBizCardService;
import com.thtns.car.service.IBizMemberService;
import com.thtns.car.service.IBizTransactionRecordService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Service
public class BizMemberServiceImpl extends ServiceImpl<BizMemberMapper, BizMember> implements IBizMemberService {

    private IBizTransactionRecordService transactionRecordService;

    private IBizCardService bizCardService;

    @Override
    public Page<BizMember> list(ListBizMemberRequest request) {
        Page<BizMember> bizMemberPage = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<BizMember> query = this.getWrapper(request);
        return page(bizMemberPage, query);

    }

    @Override
    @SneakyThrows
    public void export(ListBizMemberRequest request, HttpServletResponse response) {
        LambdaQueryWrapper<BizMember> query = this.getWrapper(request);
        List<BizMember> list = list(query);
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=会员信息.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    public LambdaQueryWrapper<BizMember> getWrapper(ListBizMemberRequest request) {
        LambdaQueryWrapper<BizMember> query = Wrappers.lambdaQuery(BizMember.class);
        query.like(StringUtils.hasText(request.getName()), BizMember::getName, request.getName());
        query.like(StringUtils.hasText(request.getPhone()), BizMember::getPhone, request.getPhone());
        query.orderByDesc(BizMember::getCreateTime);
        return query;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddBizMemberRequest request) {
        BizMember bizMember = new BizMember();
        bizMember.setName(request.getName());
        bizMember.setPhone(request.getPhone());
        bizMember.setNumberPlate(request.getNumberPlate());
        save(bizMember);
        if (request.getCardRequest() != null) {
            BizCard card = new BizCard();

            if (CardTypeEnum.year.getValue().equals(request.getCardRequest().getType())) {
                card.setType(CardTypeEnum.year.getValue());
                card.setValidDate(LocalDateTime.now().plusYears(1));
                card.setMemberId(bizMember.getId());
                bizCardService.save(card);
            }
            if (CardTypeEnum.num.getValue().equals(request.getCardRequest().getType())) {
                card.setType(CardTypeEnum.num.getValue());
                card.setValidDate(LocalDateTime.now().plusYears(1));
                card.setNum(request.getCardRequest().getNum());
                card.setMemberId(bizMember.getId());
                bizCardService.save(card);
                //添加交易记录
                BizTransactionRecord record = new BizTransactionRecord();
                record.setMemberId(bizMember.getId());
                record.setCardId(card.getId());
                record.setCardType(CardTypeEnum.num.getValue());
                transactionRecordService.save(record);


            }
            if (CardTypeEnum.stored.getValue().equals(request.getCardRequest().getType())) {
                BigDecimal balance = StringUtils.hasText(request.getCardRequest().getBalance()) ?
                        new BigDecimal(request.getCardRequest().getBalance()) :
                        new BigDecimal("0.00");
                card.setBalance(balance);
                card.setType(CardTypeEnum.stored.getValue());
                card.setMemberId(bizMember.getId());
                bizCardService.save(card);

                //添加交易记录
                BizTransactionRecord record = new BizTransactionRecord();
                record.setMemberId(bizMember.getId());
                record.setCardId(card.getId());
                record.setCardType(CardTypeEnum.stored.getValue());
                record.setPrice(balance);
                transactionRecordService.save(record);

            }


        }


    }

    @Override
    public void update(UpdateBizMemberRequest request) {
        BizMember member = getById(request.getId());
        member.setName(request.getName());
        member.setPhone(request.getPhone());
        member.setNumberPlate(request.getNumberPlate());
        updateById(member);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cashRegister(CashRegisterRequest request) {
        BizCard bizCard = bizCardService.getById(request.getCardId());
        if (bizCard != null) {
            BigDecimal price = new BigDecimal(request.getPrice());
            bizCard.setBalance(bizCard.getBalance().add(price));
            bizCardService.updateById(bizCard);
            //充值记录
            transactionRecordService.recharge(request);
        }
    }


    @Autowired
    public void setTransactionRecordService(IBizTransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }

    @Autowired
    public void setBizCardService(IBizCardService bizCardService) {
        this.bizCardService = bizCardService;
    }
}
