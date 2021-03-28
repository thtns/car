package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Data
@ApiModel(value = "SysRoleMenu对象", description = "角色菜单表")
public class SysRoleMenu {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;


}
