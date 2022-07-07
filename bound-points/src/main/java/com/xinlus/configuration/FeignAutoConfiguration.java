package com.xinlus.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 可以抽取到公共模块
 *
 * @author xinlus@126.com
 * @since 2022-07-07
 */
@Component
public class FeignAutoConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes==null){
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
//        template.header(自定义请求头Key, 自定义请求头值);
        if (headerNames == null) {
            return;
        }
        //处理上游请求头信息，传递时继续携带
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String values = request.getHeader(name);
            template.header(name, values);
        }
        //seata id传递
        String xid = RootContext.getXID();
        if (!StringUtils.isEmpty(xid)) {
            template.header(RootContext.KEY_XID, xid);
        }
    }

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
