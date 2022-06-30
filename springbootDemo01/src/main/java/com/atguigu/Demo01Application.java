package com.atguigu;

import com.atguigu.autoconfiguration.DatasourceAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;


import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Demo01Application
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/1 13:54
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.atguigu.feign")
@Import(DatasourceAutoConfiguration.class)
public class Demo01Application {
    public static void main(String[] args) throws FileNotFoundException {

        SpringApplication.run(Demo01Application.class, args);

//        FileOutputStream filterOutputStream =
//                new FileOutputStream("D:\\00\\Java\\hello.txt");
//        PrintStream printStream = new PrintStream(new File("D:\\00\\Java\\hello.txt"));
//        PrintWriter printWriter = new PrintWriter(new File("D:\\00\\Java\\hello.txt"));
//
//        System.setOut(printStream);
//        System.out.println("测试,改变打印流流向");
//        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }

//        PrintStream printStream = new PrintStream(System.out){
//            @Override
//            public void println(String x) {
//                super.println("重写的println方法");
//            }
//        };
//        System.setOut(printStream);
//
//        System.out.println("2");
//
//
//        //return;
//        try {
//            int i=0;
//            //System.exit(0);
//        }catch (Exception e){
//
//        }finally {
//            System.out.println("finally"+"2");
//            return;
//        }
        //factoryBean和beanFactory的区别
//        Object factoryBean = run.getBeanFactory().getBean("&factoryBean");
//        Object factoryBean2 = run.getBeanFactory().getBean("factoryBean");
//        System.out.println("&factoryBean = " + factoryBean);
//        System.out.println("factoryBean = " + factoryBean2);
//        Object classA = run.getBeanFactory().getBean("classA");
//        Object classB = run.getBeanFactory().getBean("classB");
//        System.out.println("classA = " + classA);
//        System.out.println("classB = " + classB);

    }
}
