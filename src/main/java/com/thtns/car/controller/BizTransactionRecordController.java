package com.thtns.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thtns.car.entity.BizMember;
import com.thtns.car.entity.BizTransactionRecord;
import com.thtns.car.request.AddBizMemberRequest;
import com.thtns.car.request.CashRegisterRequest;
import com.thtns.car.request.ListBizMemberRequest;
import com.thtns.car.request.ListBizTransactionRecordRequest;
import com.thtns.car.request.UpdateBizMemberRequest;
import com.thtns.car.service.IBizTransactionRecordService;
import com.thtns.car.util.R;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 交易记录 前端控制器
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@RestController
@RequestMapping("/biz-tr")
public class BizTransactionRecordController {

    private IBizTransactionRecordService transactionRecordService;

    @GetMapping("list")
    @ApiOperation(value = "列表", response = BizTransactionRecord.class)
    public R<Page<BizTransactionRecord>> list(ListBizTransactionRecordRequest request) {
        Page<BizTransactionRecord> list = transactionRecordService.list(request);
        return R.ok(list);
    }

    @PutMapping("cashRegister")
    @ApiOperation("交易")
    public R<Void> add(@RequestBody CashRegisterRequest request) {
        transactionRecordService.cashRegister(request);
        return R.ok();
    }

    @Autowired
    public void setTransactionRecordService(IBizTransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }
}
