package com.xinlus.service.feign;

import com.xinlus.dto.OrderInfoDTO;
import com.xinlus.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "bound-points-service")
public interface ShoppingPointFeign {
    @PostMapping(value = "/shopping-points/bound-points/add")
    Result<Integer> boundPoints(@RequestBody OrderInfoDTO orderInfoDTO);
}
