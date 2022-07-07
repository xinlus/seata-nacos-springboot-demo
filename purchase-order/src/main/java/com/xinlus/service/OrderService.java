package com.xinlus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinlus.dto.OrderDTO;
import com.xinlus.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xinlus.mapper.OrderMapper;
import com.xinlus.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
public interface OrderService {
    /**
     *
     * @return
     */
    Result<Integer> buy(OrderDTO orderDTO);
}
