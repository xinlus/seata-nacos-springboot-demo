package com.xinlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinlus.entity.ShoppingPoints;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
@Mapper
public interface ShoppingPointsMapper extends BaseMapper<ShoppingPoints> {
    int insertSelective(ShoppingPoints shoppingPoints);
}
