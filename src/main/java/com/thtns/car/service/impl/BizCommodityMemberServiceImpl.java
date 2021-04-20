package com.thtns.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizCommodityMember;
import com.thtns.car.helper.ServiceException;
import com.thtns.car.mapper.BizCommodityMemberMapper;
import com.thtns.car.request.UpdateCommodityMemberRequest;
import com.thtns.car.service.IBizCommodityMemberService;
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
public class BizCommodityMemberServiceImpl extends ServiceImpl<BizCommodityMemberMapper, BizCommodityMember> implements IBizCommodityMemberService {

    @Override
    public List<BizCommodityMember> listCommodity(Long memberId) {

        LambdaQueryWrapper<BizCommodityMember> query = Wrappers.lambdaQuery(BizCommodityMember.class);
        query.eq(BizCommodityMember::getMemberId, memberId);
        query.gt(BizCommodityMember::getNum, 0);
        query.orderByDesc(BizCommodityMember::getCreateTime);
        return list(query);
    }

    @Override
    public void update(UpdateCommodityMemberRequest request) {

        BizCommodityMember commodityMember = getById(request.getId());
        if (commodityMember.getNum() < request.getNum()) {
            throw new ServiceException("商品服务次数不够");
        }

        commodityMember.setNum(commodityMember.getNum() - request.getNum());
        updateById(commodityMember);
    }

    @Override
    public BizCommodityMember getByMemberIdAndCommodityId(Long memberId, Long commodityId) {

        LambdaQueryWrapper<BizCommodityMember> query = Wrappers.lambdaQuery(BizCommodityMember.class);
        query.eq(BizCommodityMember::getMemberId, memberId);
        query.eq(BizCommodityMember::getCommodityId, commodityId);
        return getOne(query);
    }
}
