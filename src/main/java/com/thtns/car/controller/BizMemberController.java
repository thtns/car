package com.thtns.car.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizCard;
import com.thtns.car.entity.BizMember;
import com.thtns.car.request.*;
import com.thtns.car.service.IBizCardService;
import com.thtns.car.service.IBizMemberService;
import com.thtns.car.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    private IBizCardService bizCardService;

    @GetMapping("list")
    @ApiOperation(value = "列表", response = BizMember.class)
    public R<Page<BizMember>> list(ListBizMemberRequest request) {
        Page<BizMember> list = bizMemberService.list(request);
        return R.ok(list);
    }

    @GetMapping("listCard/{memberId}")
    @ApiOperation(value = "办理的卡", response = BizCard.class)
    public R<List<BizCard>> listCard(@PathVariable Long memberId) {
        List<BizCard> list = bizCardService.listCard(memberId);
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

    @PutMapping("applyCard")
    @ApiOperation("办卡")
    public R<Void> applyCard(@RequestBody ApplyCardRequest request) {
        bizMemberService.applyCard(request);
        return R.ok();
    }

    @PutMapping("transaction")
    @ApiOperation("扣费")
    public R<Void> add(@RequestBody TransactionRequest request) {
        bizMemberService.transaction(request);
        return R.ok();
    }

    @GetMapping("getCarName/{name}")
    @ApiOperation(value = "列表", response = String.class)
    public R<List<String>> getCarName(@PathVariable String name) {
        List<String> list = bizMemberService.getCarName(name);
        return R.ok(list);
    }

    @Autowired
    public void setBizMemberService(IBizMemberService bizMemberService) {
        this.bizMemberService = bizMemberService;
    }

    @Autowired
    public void setBizCardService(IBizCardService bizCardService) {
        this.bizCardService = bizCardService;
    }


}
