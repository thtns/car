package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单权限标识")
    private String permission;

    @ApiModelProperty(value = "前端URL")
    private String path;

    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "VUE页面")
    private String component;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "0-开启，1- 关闭")
    private String keepAlive;

    @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）")
    private String type;


}
