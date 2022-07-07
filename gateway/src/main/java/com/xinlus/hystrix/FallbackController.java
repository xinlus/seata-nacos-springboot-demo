package com.xinlus.hystrix;

import com.xinlus.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("fallback")
    public Result fallback(){
        return Result.error("当前访问人数太多，请稍候再试！");
    }
}
