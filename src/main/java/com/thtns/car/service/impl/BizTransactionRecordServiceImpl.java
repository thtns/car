package com.thtns.car.service.impl;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BaseEntity;
import com.thtns.car.entity.BizMember;
import com.thtns.car.entity.BizTransactionRecord;
import com.thtns.car.enums.TransactionTypeEnum;
import com.thtns.car.helper.ServiceException;
import com.thtns.car.mapper.BizTransactionRecordMapper;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizTransactionRecordRequest;
import com.thtns.car.service.IBizMemberService;
import com.thtns.car.service.IBizTransactionRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 交易记录 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Service
public class BizTransactionRecordServiceImpl extends ServiceImpl<BizTransactionRecordMapper, BizTransactionRecord>
        implements IBizTransactionRecordService {

    private IBizMemberService bizMemberService;

    @Override
    public Page<BizTransactionRecord> list(ListBizTransactionRecordRequest request) {

        Page<BizTransactionRecord> page = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<BizTransactionRecord> query = Wrappers.lambdaQuery(BizTransactionRecord.class);
        query.eq(request.getMemberId() != null, BizTransactionRecord::getMemberId, request.getMemberId());
        query.orderByDesc(BizTransactionRecord::getCreateTime);
        return page(page, query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cashRegister(CashRegisterRequest request) {
        BizTransactionRecord transactionRecord = new BizTransactionRecord();
        if (request.getMemberId() != null) {
            BizMember member = bizMemberService.getById(request.getMemberId());
            BigDecimal cashPrice = new BigDecimal(request.getPrice());
            //消费金额大于卡内余额
            if (cashPrice.compareTo(member.getBalance()) == 1) {
                throw new ServiceException(5001, "卡内余额不足,请充值");
            }
            //扣除金额
            transactionRecord.setMemberId(request.getMemberId());
            member.setBalance(member.getBalance().subtract(cashPrice));
            bizMemberService.updateById(member);

        }
        transactionRecord.setRemark(request.getRemark());
        transactionRecord.setPrice(new BigDecimal(request.getPrice()));
        transactionRecord.setType(TransactionTypeEnum.consumption);
        save(transactionRecord);
    }

    @Override
    public void recharge(CashRegisterRequest request) {
        BizTransactionRecord record = new BizTransactionRecord();
        record.setPrice(
                StringUtils.hasText(request.getPrice()) ? new BigDecimal(request.getPrice()) : new BigDecimal("0.00"));
        record.setType(TransactionTypeEnum.recharge);
        record.setMemberId(request.getMemberId());
        save(record);
    }

    @Autowired
    public void setBizMemberService(IBizMemberService bizMemberService) {
        this.bizMemberService = bizMemberService;
    }
}
