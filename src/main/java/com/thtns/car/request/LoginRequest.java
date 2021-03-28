package com.thtns.car.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRequest {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;


}
