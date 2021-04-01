package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddBizCardRequest {

    @ApiModelProperty(value = "类型")
    private Integer cardType;

    @ApiModelProperty(value = "金额")
    private String balance;

    @ApiModelProperty(value = "次数")
    private Integer num;


}
