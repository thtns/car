package com.thtns.car.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thtns.car.entity.BizTransactionRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thtns.car.request.ListBizTransactionRecordRequest;
import com.thtns.car.response.bizTrExportResponse;

/**
 * <p>
 * 交易记录 Mapper 接口
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
public interface BizTransactionRecordMapper extends BaseMapper<BizTransactionRecord> {

    List<bizTrExportResponse> exportList(@Param("request") ListBizTransactionRecordRequest request);

}
