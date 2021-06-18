package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizMember;
import com.thtns.car.request.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    void export(ListBizMemberRequest request, HttpServletResponse response);

    void add(AddBizMemberRequest request);

    void update(UpdateBizMemberRequest request);

    void cashRegister(CashRegisterRequest request);

    List<String> getCarName(String name);

    void applyCard(ApplyCardRequest request);

    void transaction(TransactionRequest request);

    void enable(Long id);

    void revoke(RevokeRequest request);

}
