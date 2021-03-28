package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.SysUser;
import com.thtns.car.mapper.SysUserMapper;
import com.thtns.car.request.LoginRequest;
import com.thtns.car.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public void login(LoginRequest request) {


    }
}
