package com.test.javaee;

import java.util.Map;
import java.util.concurrent.Future;

/**
 * ThreadLocalTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/26 14:48
 **/
public class ThreadLocalTest {

    private static final ThreadLocal THREAD_LOCAL=new ThreadLocal();

    public static void main(String[] args) {

        THREAD_LOCAL.set(223);
        System.out.println(THREAD_LOCAL.get());

    }

}
