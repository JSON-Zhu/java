package com.test.reflect;

import java.lang.reflect.Constructor;
import java.sql.Date;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * D3NewInstance
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 23:49
 **/
@MyAnnotation(value = "testClass")
public class D3NewInstance extends Person<String> implements MyInterface<String> {
    private String name;

    private D3NewInstance(String name) {

        System.out.println("对象创建成功");

    }


//    public D3NewInstance(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "D3NewInstance{" +
                "name='" + name + '\'' +
                '}';
    }

    @MyAnnotation("test")
    public void main(String[] args) throws Exception {


        Class<D3NewInstance> d3NewInstanceClass = D3NewInstance.class;
        Constructor<D3NewInstance> constructor = d3NewInstanceClass.getConstructor(String.class);
        D3NewInstance test = constructor.newInstance("test");
        System.out.println(test);

        d3NewInstanceClass.newInstance();


//        for (int i = 0; i < 19; i++) {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("new Random().nextInt(3) = " + new Random().nextInt(3));
//        }

//        Class<?> aClass = Class.forName("java.sql.Date");
//        Object o = aClass.newInstance();
//        System.out.println(o);


    }

    public synchronized void testClass() throws Exception {

    }


}

class Person<T> {

}