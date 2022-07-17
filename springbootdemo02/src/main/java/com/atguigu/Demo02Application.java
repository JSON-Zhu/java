package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Demo02Application
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/29 20:24
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan(basePackages = "com.atguigu.filter")
public class Demo02Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class,args);
    }
}
