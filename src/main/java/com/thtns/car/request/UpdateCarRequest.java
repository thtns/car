package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyj
 * node 添加车辆
 */
@Data
public class UpdateCarRequest {

    @ApiModelProperty(value = "carId")
    private Long carId;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "车型名称")
    private String carName;


}
