package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCommodity;
import com.thtns.car.mapper.BizCommodityMapper;
import com.thtns.car.request.AddCommodityRequest;
import com.thtns.car.request.UpdateCommodityRequest;
import com.thtns.car.service.IBizCommodityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-04-13
 */
@Service
public class BizCommodityServiceImpl extends ServiceImpl<BizCommodityMapper, BizCommodity> implements IBizCommodityService {

    @Override
    public void add(AddCommodityRequest request) {

        BizCommodity bizCommodity = new BizCommodity();
        bizCommodity.setName(request.getName());
        save(bizCommodity);

    }

    @Override
    public void update(UpdateCommodityRequest request) {

        BizCommodity byId = getById(request.getId());
        byId.setName(request.getName());
        updateById(byId);
    }

    @Override
    public void del(List<Long> ids) {

        removeByIds(ids);

    }
}
