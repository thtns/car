package com.thtns.car.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.thtns.car.response.LineTrResponse;
import com.thtns.car.response.PieTrResponse;
import com.thtns.car.service.IBizTransactionRecordService;
import com.thtns.car.util.R;

import io.swagger.annotations.Api;
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
@Api(tags = "交易记录")
public class BizTransactionRecordController {

    private IBizTransactionRecordService transactionRecordService;

    @GetMapping("list")
    @ApiOperation(value = "列表", response = BizTransactionRecord.class)
    public R<Page<BizTransactionRecord>> list(ListBizTransactionRecordRequest request) {
        Page<BizTransactionRecord> list = transactionRecordService.list(request);
        return R.ok(list);
    }

    @GetMapping("export")
    @ApiOperation(value = "会员数据导出")
    public R export(ListBizTransactionRecordRequest request, HttpServletResponse response) {
        transactionRecordService.export(request, response);
        return R.ok();
    }


    @GetMapping("line")
    @ApiOperation(value = "折线", response = LineTrResponse.class)
    public R<List<LineTrResponse>> line(ListBizTransactionRecordRequest request) {
        List<LineTrResponse> line = transactionRecordService.line(request);
        return R.ok(line);
    }

    @GetMapping("pie")
    @ApiOperation(value = "饼图", response = PieTrResponse.class)
    public R<List<PieTrResponse>> pie(ListBizTransactionRecordRequest request) {
        List<PieTrResponse> pie = transactionRecordService.pie(request);
        return R.ok(pie);
    }

    @Autowired
    public void setTransactionRecordService(IBizTransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }
}
