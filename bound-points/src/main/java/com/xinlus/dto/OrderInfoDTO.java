package com.xinlus.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 *  Feign使用的实体类可以抽取
 * 所有feign使用门面模式取得数据
 *
 * @author xinlus@126.com
 * @since 2022-07-07
 */
@Setter
@Getter
public class OrderInfoDTO {
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("金额")
    private BigDecimal amount;
    @ApiModelProperty("开启错误测试")
    private Boolean enableError=false;
}
