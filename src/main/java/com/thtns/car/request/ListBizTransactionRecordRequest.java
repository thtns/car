package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : liuyj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListBizTransactionRecordRequest extends PageRequest {

    @ApiModelProperty("会员ID")
    private Long memberId;

    @ApiModelProperty("交易类型")
    private Integer type;

    @ApiModelProperty("开始时间")
    private String beginDate;
    @ApiModelProperty("结束时间")
    private String endDate;

}
