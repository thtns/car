package com.thtns.car.controller;

import com.thtns.car.request.LoginRequest;
import com.thtns.car.service.ISysUserService;
import com.thtns.car.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Api(tags = "授权")
public class LoginController {

    private ISysUserService userService;


    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginRequest request) {
        userService.login(request);
        return R.ok();
    }

    @Autowired
    public void setUserService(ISysUserService userService) {
        this.userService = userService;
    }
}
