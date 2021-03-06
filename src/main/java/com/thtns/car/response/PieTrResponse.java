package com.thtns.car.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class PieTrResponse {

    @ApiModelProperty("盈利")
    private String profit;

    @ApiModelProperty("日期")
    private String type;

}
