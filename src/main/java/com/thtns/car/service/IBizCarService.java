package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizCar;
import com.thtns.car.request.AddCarRequest;

import java.util.List;

/**
 * <p>
 * 车 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-04-12
 */
public interface IBizCarService extends IService<BizCar> {


    List<BizCar> listCar(Long memberId);

    void addCar(AddCarRequest request);

}
