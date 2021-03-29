package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.UpdateBizMemberRequest;

/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
public interface IBizMemberService extends IService<BizMember> {

    Page<BizMember> list(ListBizMemberRequest request);

    void add(AddBizMemberRequest request);

    void update(UpdateBizMemberRequest request);

    void cashRegister(CashRegisterRequest request);

    void reset(Long id);

}
