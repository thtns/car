package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizCard;
import com.thtns.car.enums.CardTypeEnum;

import java.util.List;

/**
 * <p>
 * 会员办理的业务卡 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
public interface IBizCardService extends IService<BizCard> {

    List<BizCard> listCard(Long carId);


    boolean exists(Long memberId, CardTypeEnum cardTypeEnum);


    List<BizCard> listByMemberIdAndCardType(List<Long> memberIds, CardTypeEnum cardTypeEnum);


}
