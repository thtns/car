package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class TransactionRequest {

    @ApiModelProperty("会员ID")
    private Long memberId;

    @ApiModelProperty("金额")
    private String price;

    @ApiModelProperty("卡ID")
    private Long cardId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("carId")
    private Long carId;

}
