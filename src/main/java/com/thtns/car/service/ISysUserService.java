package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.SysUser;
import com.thtns.car.request.LoginRequest;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
public interface ISysUserService extends IService<SysUser> {


    void login(LoginRequest request);

}
