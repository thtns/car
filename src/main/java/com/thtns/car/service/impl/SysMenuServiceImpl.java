package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.SysMenu;
import com.thtns.car.mapper.SysMenuMapper;
import com.thtns.car.service.ISysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-28
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

}
