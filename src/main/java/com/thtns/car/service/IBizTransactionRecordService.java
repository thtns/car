package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizMember;
import com.thtns.car.entity.BizTransactionRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.ListBizTransactionRecordRequest;

/**
 * <p>
 * 交易记录 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
public interface IBizTransactionRecordService extends IService<BizTransactionRecord> {

    Page<BizTransactionRecord> list(ListBizTransactionRecordRequest request);

    void cashRegister(CashRegisterRequest request);

    void recharge(CashRegisterRequest request);

}
