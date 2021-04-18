package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : liuyj
 */
@Data
public class ApplyCardRequest {

    @ApiModelProperty("会员ID")
    private Long memberId;

    @ApiModelProperty("会员类型")
    private Integer cardType;

    @ApiModelProperty("次卡次数")
    private Integer num;

    @ApiModelProperty("储蓄卡金额")
    private String balance;

    @ApiModelProperty("车ID")
    private Long carId;

    @ApiModelProperty("赠送服务集合")
    private List<AddBizCommodityRequest> commodityRequests;

}
