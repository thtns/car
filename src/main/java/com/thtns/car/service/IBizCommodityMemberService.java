package com.thtns.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thtns.car.entity.BizCommodityMember;
import com.thtns.car.request.UpdateCommodityMemberRequest;

import java.util.List;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author liuyj
 * @since 2021-04-13
 */
public interface IBizCommodityMemberService extends IService<BizCommodityMember> {


    List<BizCommodityMember> listCommodity(Long memberId);


    void update(UpdateCommodityMemberRequest request);

    BizCommodityMember getByMemberIdAndCommodityId(Long memberId, Long commodityId);

}
