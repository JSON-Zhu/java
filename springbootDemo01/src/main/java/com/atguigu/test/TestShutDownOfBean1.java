//package com.atguigu.test;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * TestShutDownOfBean
// *
// * @author XQ.Zhu
// * @version 1.0
// * 2022/6/17 1:39
// **/
//public class TestShutDownOfBean1 implements DisposableBean, DestructionAwareBeanPostProcessor {
//
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("实现DisposableBean");
//    }
//
//    @Override
//    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
//        System.out.println("实现DestructionAwareBeanPostProcessor");
//    }
//
//    public void init(){
//        System.out.println("自定义初始化方法");
//    }
//    public void destroy2(){
//        System.out.println("自定义销毁方法");
//    }
//}
