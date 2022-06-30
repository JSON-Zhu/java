package com.atguigu.controller;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.cloud.nacos.ribbon.NacosServerList;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.atguigu.feign.SpringDemo02Feign;
import com.atguigu.pojo.Comment;
import com.atguigu.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * controller
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/1 13:45
 **/
@RestController
@Slf4j
public class Controller {

    @NacosInjected
    NacosServer nacosServer;

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping("/test")
    @Scheduled(cron = "* * * * * *")
    public void myTask() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @GetMapping("/test2")
    public String testMockmvc() {
        String x = "zhangSan";
        //LOGGER.info("进入-controller方法:{}",x);
        log.info("进入方法,slf4j-{}", x);
        String demo02 = commentService.testFeign();
        return "hello world" + demo02;
    }

    @PostMapping("/saveComment")
    public void saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

}
