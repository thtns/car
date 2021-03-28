package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Data
@ApiModel(value = "SysUserRole对象", description = "用户角色表")
public class SysUserRole {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;


}
