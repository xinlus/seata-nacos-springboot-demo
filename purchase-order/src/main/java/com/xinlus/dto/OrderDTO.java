package com.xinlus.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {
    @ApiModelProperty("开启错误测试")
    private Boolean enableError=false;
}
