package com.xinlus.controller;


import com.xinlus.dto.OrderInfoDTO;
import com.xinlus.service.ShoppingPointsService;
import com.xinlus.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
@RestController
@RequestMapping("/shopping-points")
public class ShoppingPointsController {
    @Autowired
    private ShoppingPointsService service;
    @PostMapping(value = "/bound-points/add")
    public Result<Integer> boundPoints(@RequestBody OrderInfoDTO orderInfoDTO){
        return service.boundPoints(orderInfoDTO);
    }
}
