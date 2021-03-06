package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : liuyj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListBizMemberRequest extends PageRequest {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("禁启用")
    private Boolean status;

    @ApiModelProperty("会员卡号")
    private Long id;

}
