package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车
 * </p>
 *
 * @author liuyj
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BizCar对象", description = "车")
public class BizCar extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "车型名称")
    private String carName;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;


}
