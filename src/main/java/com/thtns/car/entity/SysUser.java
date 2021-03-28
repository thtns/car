package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUser对象", description = "用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    private String password;

    @ApiModelProperty(value = "随机盐")
    private String salt;

    @ApiModelProperty(value = "简介")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String avatar;


}
