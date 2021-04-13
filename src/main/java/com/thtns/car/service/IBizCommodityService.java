package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizCommodity;
import com.thtns.car.request.AddCommodityRequest;
import com.thtns.car.request.UpdateCommodityRequest;

import java.util.List;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-04-13
 */
public interface IBizCommodityService extends IService<BizCommodity> {


    void add(AddCommodityRequest request);

    void update(UpdateCommodityRequest request);

    void del(List<Long> ids);

}
