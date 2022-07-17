package com.atguigu.config;

import com.atguigu.interceptor.TestInterceptor1;
import com.atguigu.interceptor.TestInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * InterceptorConfig
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/13 13:17
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private TestInterceptor1 testInterceptor1;

    @Autowired
    private TestInterceptor2 testInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor1);
        registry.addInterceptor(testInterceptor2);
    }
}
