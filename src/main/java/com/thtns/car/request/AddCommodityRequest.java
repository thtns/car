package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddCommodityRequest {

    @ApiModelProperty("商品名称")
    private String name;


}
