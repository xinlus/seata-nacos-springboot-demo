package com.xinlus.controller;

import com.xinlus.dto.OrderDTO;
import com.xinlus.service.OrderService;
import com.xinlus.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "购买方")
@RestController
@RequestMapping("order")
public class PurchaseOrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("buy")
    public Result<Integer> buyOrder(@RequestBody OrderDTO orderDTO){
        return orderService.buy(orderDTO);
    }
}
