package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCard;
import com.thtns.car.mapper.BizCardMapper;
import com.thtns.car.service.IBizCardService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员办理的业务卡 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Service
public class BizCardServiceImpl extends ServiceImpl<BizCardMapper, BizCard> implements IBizCardService {

    @Override
    public List<BizCard> listCard(Long memberId) {

        LambdaQueryWrapper<BizCard> query = Wrappers.lambdaQuery(BizCard.class);
        query.eq(BizCard::getMemberId, memberId);
        query.orderByDesc(BizCard::getCreateTime);
        return list(query);
    }
}
