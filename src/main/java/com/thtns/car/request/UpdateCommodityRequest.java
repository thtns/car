package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateCommodityRequest {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("name")
    private String name;


}
