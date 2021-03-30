package com.thtns.car.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thtns.car.entity.BizMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员 Mapper 接口
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
public interface BizMemberMapper extends BaseMapper<BizMember> {

    List<String> getAllByCarName(@Param("name") String name);


}
