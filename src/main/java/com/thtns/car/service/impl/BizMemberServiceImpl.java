package com.thtns.car.service.impl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizMember;
import com.thtns.car.enums.UserTypeEnum;
import com.thtns.car.mapper.BizMemberMapper;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.UpdateBizMemberRequest;
import com.thtns.car.service.IBizMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.service.IBizTransactionRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.SneakyThrows;
import sun.nio.ch.IOUtil;

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
        bizMember.setBalance(StringUtils.hasText(request.getBalance()) ?
                new BigDecimal(request.getBalance()) :
                new BigDecimal("0.00"));
        bizMember.setType(request.getType() != null ? request.getType() : UserTypeEnum.ordinary.getValue());
        save(bizMember);

        if (StringUtils.hasText(request.getBalance())) {
            CashRegisterRequest cashRegisterRequest = new CashRegisterRequest();
            cashRegisterRequest.setMemberId(bizMember.getId());
            cashRegisterRequest.setPrice(request.getBalance());
            transactionRecordService.recharge(cashRegisterRequest);
        }

    }

    @Override
    public void update(UpdateBizMemberRequest request) {
        BizMember member = getById(request.getId());
        member.setName(request.getName());
        member.setPhone(request.getPhone());
        member.setNumberPlate(request.getNumberPlate());
        member.setBalance(new BigDecimal(request.getBalance()));
        member.setType(UserTypeEnum.parse(request.getType()).getValue());
        updateById(member);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cashRegister(CashRegisterRequest request) {
        BizMember member = getById(request.getMemberId());
        if (member != null) {
            BigDecimal price = new BigDecimal(request.getPrice());
            member.setBalance(member.getBalance().add(price));
            updateById(member);
            //充值记录
            transactionRecordService.recharge(request);
        }
    }

    @Override
    public void reset(Long id) {
        BizMember member = getById(id);
        member.setBalance(new BigDecimal("0.00"));
        updateById(member);
    }

    @Autowired
    public void setTransactionRecordService(IBizTransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }
}
