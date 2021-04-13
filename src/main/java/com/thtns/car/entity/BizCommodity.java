package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author liuyj
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BizCommodity对象", description = "商品")
public class BizCommodity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名称")
    private String name;


}
