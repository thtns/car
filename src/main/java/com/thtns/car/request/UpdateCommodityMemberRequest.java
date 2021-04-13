package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateCommodityMemberRequest {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("name")
    private Integer num;


}
