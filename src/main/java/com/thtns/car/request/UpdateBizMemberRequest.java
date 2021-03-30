package com.thtns.car.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class UpdateBizMemberRequest {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "车型名称")
    private String carName;
}
