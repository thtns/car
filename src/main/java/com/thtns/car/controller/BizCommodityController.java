package com.thtns.car.controller;


import com.thtns.car.entity.BizCommodity;
import com.thtns.car.request.AddCommodityRequest;
import com.thtns.car.request.UpdateCommodityRequest;
import com.thtns.car.service.IBizCommodityService;
import com.thtns.car.util.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/biz-commodity")
public class BizCommodityController {


    private IBizCommodityService bizCommodityService;


    @GetMapping("{id}")
    @ApiOperation("根据id获取商品")
    public R<BizCommodity> get(@PathVariable("id") Long id) {
        return R.ok(bizCommodityService.getById(id));
    }

    @PostMapping("list")
    @ApiOperation("商品列表")
    public R<List<BizCommodity>> list() {
        return R.ok(bizCommodityService.list());
    }

    @PostMapping("add")
    @ApiOperation("添加商品")
    public R add(@RequestBody AddCommodityRequest request) {
        bizCommodityService.add(request);
        return R.ok();
    }

    @PutMapping
    @ApiOperation("更新商品")
    public R update(@RequestBody UpdateCommodityRequest request) {
        bizCommodityService.update(request);
        return R.ok();
    }

    @DeleteMapping()
    @ApiOperation("删除景区")
    public R del(@RequestBody Long[] ids) {
        bizCommodityService.del(Arrays.asList(ids));
        return R.ok();
    }

    @Autowired
    public void setBizCommodityService(IBizCommodityService bizCommodityService) {
        this.bizCommodityService = bizCommodityService;
    }
}
