//package com.atguigu.test;
//
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
///**
// * TestFactoryBean
// *
// * @author XQ.Zhu
// * @version 1.0
// * 2022/6/19 17:24
// **/
////@Component("factoryBeanx")
////public class TestFactoryBean implements FactoryBean<Object> {
////    private String name;
////
////    @Autowired
////    public TestFactoryBean(@Qualifier(value = "y")String name){
////        this.name=name;
////    }
//////    @Qualifier(value = "y")
//////    public void setName(String name){
//////        this.name=name;
//////    }
////
////    @Override
////    public Object getObject() throws Exception {
////        String test="test22213213";
////        return test;
////    }
////
////    @Override
////    public Class<?> getObjectType() {
////        return null;
////    }
////    @Bean
////    public String x(){
////        return "测试名字";
////    }
////    @Bean
////    public String y(){
////        return "测试名字y";
////    }
//}
