package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRole对象", description = "系统角色表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String roleName;

    private String roleCode;

    private String roleDesc;


}
