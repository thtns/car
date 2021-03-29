package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class RechargeBizMemberRequest {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty(value = "卡内余额")
    private String balance;

}
