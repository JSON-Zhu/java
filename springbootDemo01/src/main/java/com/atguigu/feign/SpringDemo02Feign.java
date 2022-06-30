package com.atguigu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringDemo02Feign
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/29 20:13
 **/
@FeignClient(value = "springbootDemo02",path = "/demo02")
public interface SpringDemo02Feign {

    @RequestMapping(value = "/test")
    String demo02();

}
