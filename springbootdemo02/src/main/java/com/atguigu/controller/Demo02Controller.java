package com.atguigu.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo02Controller
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/29 20:15
 **/
@RestController
@RequestMapping("/demo02")
public class Demo02Controller {

    @NacosInjected
    NamingService namingService;

    @RequestMapping("/test")
    public String demo02(){
        System.out.println("访问demo02");
        return "demo02";
    }

}
