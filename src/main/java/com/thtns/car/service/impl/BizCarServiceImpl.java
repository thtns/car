package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCar;
import com.thtns.car.mapper.BizCarMapper;
import com.thtns.car.request.AddCarRequest;
import com.thtns.car.request.UpdateCarRequest;
import com.thtns.car.service.IBizCarService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<BizCar> listCar(Long memberId) {

        LambdaQueryWrapper<BizCar> query = Wrappers.lambdaQuery(BizCar.class);
        query.eq(BizCar::getMemberId, memberId);
        query.orderByDesc(BizCar::getCreateTime);
        return list(query);
    }

    @Override
    public void addCar(AddCarRequest request) {
        BizCar bizCar = new BizCar();
        bizCar.setCarName(request.getCarName());
        bizCar.setMemberId(request.getMemberId());
        bizCar.setNumberPlate(request.getNumberPlate());
        save(bizCar);
    }

    @Override
    public void updateCar(UpdateCarRequest request) {
        BizCar car = getById(request.getCarId());
        car.setCarName(request.getCarName());
        car.setNumberPlate(request.getNumberPlate());
        updateById(car);
    }
}
