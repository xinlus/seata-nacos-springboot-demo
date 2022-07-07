package com.xinlus.service;

import com.xinlus.dto.OrderInfoDTO;
import com.xinlus.entity.ShoppingPoints;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xinlus.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
public interface ShoppingPointsService {

    Result<Integer> boundPoints(OrderInfoDTO orderInfoDTO);
}
