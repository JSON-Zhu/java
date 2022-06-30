package com.test.proxy;

import com.test.io.FileTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * FieldTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 8:53
 **/
public class FieldTest extends FieldFather {
    static int anInt=1;
    static {
        anInt=3;
        System.out.println(anInt);
    }
    public FieldTest(){
        System.out.println("child constructor");
    }

    @Override
    public void test() {
        System.out.println("child");
    }

    public static void main(String[] args) throws Exception{

        FieldFather fieldTest = new FieldTest();
        fieldTest.test();

        ClassLoader classLoader = fieldTest.getClass().getClassLoader();


//        Class<ProxyTest.Star> starClass = ProxyTest.Star.class;
//        ProxyTest.Star star = starClass.newInstance();
//        Method makeMoney = starClass.getMethod("makeMoney");
//
//        Object invoke = makeMoney.invoke(star);
//        System.out.println(invoke.toString());
//
//        Field moneyMade = starClass.getDeclaredField("moneyMade");
//        moneyMade.setAccessible(true);
//        moneyMade.set(star,50000);
//        System.out.println(moneyMade.get(star).getClass().getName());//不用强转,就是double
    }
}
class FieldFather {
    static int bnInt=1;
    static {
        bnInt=2;
        System.out.println(bnInt);
    }

    public FieldFather(){
        System.out.println("father constructor");
    }
    public void test(){
        System.out.println("father");
    }
}
