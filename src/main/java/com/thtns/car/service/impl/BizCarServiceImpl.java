package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCar;
import com.thtns.car.mapper.BizCarMapper;
import com.thtns.car.service.IBizCarService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-04-12
 */
@Service
public class BizCarServiceImpl extends ServiceImpl<BizCarMapper, BizCar> implements IBizCarService {

}
