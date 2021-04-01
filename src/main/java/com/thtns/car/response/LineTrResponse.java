package com.thtns.car.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class LineTrResponse {

    @ApiModelProperty("充钱")
    private String profit;

    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("消费")
    private String consumption;

}
