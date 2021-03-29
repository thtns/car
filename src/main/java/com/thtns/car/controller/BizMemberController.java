package com.thtns.car.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizMember;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.UpdateBizMemberRequest;
import com.thtns.car.service.IBizMemberService;
import com.thtns.car.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@RestController
@RequestMapping("biz-member")
@Api(tags = "会员")
public class BizMemberController {

    private IBizMemberService bizMemberService;

    @GetMapping("list")
    @ApiOperation(value = "列表", response = BizMember.class)
    public R<Page<BizMember>> list(ListBizMemberRequest request) {
        Page<BizMember> list = bizMemberService.list(request);
        return R.ok(list);
    }

    @GetMapping("export")
    @ApiOperation(value = "会员数据导出")
    public R export(ListBizMemberRequest request, HttpServletResponse response) {
        bizMemberService.export(request, response);
        return R.ok();
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public R<Void> add(@RequestBody AddBizMemberRequest request) {
        bizMemberService.add(request);
        return R.ok();
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public R<Void> update(@RequestBody UpdateBizMemberRequest request) {
        bizMemberService.update(request);
        return R.ok();
    }

    @PutMapping("recharge")
    @ApiOperation("充值")
    public R<Void> recharge(@RequestBody CashRegisterRequest request) {
        bizMemberService.cashRegister(request);
        return R.ok();
    }

    @PutMapping("reset/{id}")
    @ApiOperation("重置")
    public R<Void> reset(@PathVariable Long id) {
        bizMemberService.reset(id);
        return R.ok();
    }

    @Autowired
    public void setBizMemberService(IBizMemberService bizMemberService) {
        this.bizMemberService = bizMemberService;
    }
}
