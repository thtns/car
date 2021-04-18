package com.thtns.car.controller;


import com.thtns.car.entity.BizCommodityMember;
import com.thtns.car.request.UpdateCommodityMemberRequest;
import com.thtns.car.service.IBizCommodityMemberService;
import com.thtns.car.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author liuyj
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/biz-commodity-member")
@Api(tags = "会员与赠送服务相关接口")
public class BizCommodityMemberController {

    private IBizCommodityMemberService bizCommodityMemberService;

    @GetMapping("listCommodity/{memberId}")
    @ApiOperation(value = "服务内容", response = BizCommodityMember.class)
    public R<List<BizCommodityMember>> listCommodity(@PathVariable Long memberId) {
        List<BizCommodityMember> list = bizCommodityMemberService.listCommodity(memberId);
        return R.ok(list);
    }

    @PutMapping
    @ApiOperation("更新商品服务数量")
    public R update(@RequestBody UpdateCommodityMemberRequest request) {
        bizCommodityMemberService.update(request);
        return R.ok();
    }


    @Autowired
    public void setBizCommodityMemberService(IBizCommodityMemberService bizCommodityMemberService) {
        this.bizCommodityMemberService = bizCommodityMemberService;
    }
}
