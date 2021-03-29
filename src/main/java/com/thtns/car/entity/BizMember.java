package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BizMember对象", description = "会员")
public class BizMember extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "手机号码")
    private String phone;

}
