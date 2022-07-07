package com.xinlus.service.impl;

import com.xinlus.dto.OrderDTO;
import com.xinlus.dto.OrderInfoDTO;
import com.xinlus.entity.Order;
import com.xinlus.mapper.AccountMapper;
import com.xinlus.mapper.OrderMapper;
import com.xinlus.service.AccountService;
import com.xinlus.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinlus.service.feign.ShoppingPointFeign;
import com.xinlus.vo.Result;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final AtomicInteger tailNum = new AtomicInteger(1000);
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ShoppingPointFeign shoppingPointFeign;

    @GlobalTransactional
    @Override
    public Result<Integer> buy(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();
        String orderNo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + tailNum.getAndIncrement();
        order.setOrderNo(orderNo);
        orderMapper.insertSelective(order);
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setOrderNo(order.getOrderNo());
        orderInfoDTO.setAmount(new BigDecimal(10));
        orderInfoDTO.setEnableError(orderDTO.getEnableError());
        accountMapper.updateAccountAmountById(orderInfoDTO.getAmount(),1);
//        String xid = RootContext.unbind();//关闭分布式全局事务
//        //需要关闭的业务逻辑代码
//        RootContext.bind(xid);//开启分布式全局事务


        return shoppingPointFeign.boundPoints(orderInfoDTO);
    }
}
