package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BaseEntity;
import com.thtns.car.entity.BizCar;
import com.thtns.car.entity.BizCard;
import com.thtns.car.enums.CardTypeEnum;
import com.thtns.car.mapper.BizCardMapper;
import com.thtns.car.service.IBizCarService;
import com.thtns.car.service.IBizCardService;
import com.thtns.car.service.IBizMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    private IBizMemberService bizMemberService;
    private IBizCarService bizCarService;

    @Override
    public List<BizCard> listCard(Long carId) {

        BizCar car = bizCarService.getById(carId);

        LambdaQueryWrapper<BizCard> query = Wrappers.lambdaQuery(BizCard.class);
        query.eq(BizCard::getCarId, carId);
        //车型下面所有的卡
        List<BizCard> list1 = list(query);

        //查询该用户的储蓄卡
        LambdaQueryWrapper<BizCard> query2 = Wrappers.lambdaQuery(BizCard.class);
        query2.eq(BizCard::getMemberId, car.getMemberId());
        query2.eq(BizCard::getType, CardTypeEnum.stored.getValue());
        List<BizCard> list2 = list(query2);

        list1.addAll(list2);

        return list1.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseEntity::getId))), ArrayList::new));

    }

    @Override
    public boolean exists(Long memberId, CardTypeEnum cardTypeEnum) {

        LambdaQueryWrapper<BizCard> query = Wrappers.lambdaQuery(BizCard.class);
        query.eq(BizCard::getMemberId, memberId);
        query.eq(BizCard::getType, cardTypeEnum.getValue());
        int count = count(query);
        return count < 1;
    }

    @Autowired
    public void setBizMemberService(IBizMemberService bizMemberService) {
        this.bizMemberService = bizMemberService;
    }

    @Autowired
    public void setBizCarService(IBizCarService bizCarService) {
        this.bizCarService = bizCarService;
    }
}
