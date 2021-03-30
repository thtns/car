package com.thtns.car.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizMember;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.ApplyCardRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.TransactionRequest;
import com.thtns.car.request.UpdateBizMemberRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Na;

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

}
