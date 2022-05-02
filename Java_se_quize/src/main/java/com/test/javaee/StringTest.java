package com.test.javaee;

import sun.misc.Launcher;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.Buffer;
import java.util.HashMap;

/**
 * StringTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/18 22:26
 **/
public class StringTest {

    public static void main(String[] args) {
        String a= "b"+"c";
        String d= "b"+new String("c");
        System.out.println(a==d);
        System.out.println(a.hashCode());
        System.out.println(d.hashCode());

        a.getClass().getClassLoader();
        ClassLoader classLoader = StringTest.class.getClassLoader();

        System.out.println(classLoader.getClass().getName());
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent.getClass().getName());
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

        BigDecimal bigDecimal = new BigDecimal(2, MathContext.DECIMAL128);
        Double double1=6.78932;
        System.out.println(double1+1.0);
        System.out.println(bigDecimal.doubleValue());
    }
}
