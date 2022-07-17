package com.atguigu.aspect;

/**
 * CustomThreadLocal
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/5 21:57
 **/
public class CustomThreadLocal {
    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    public static ThreadLocal<Integer> getThreadLocal() {
        return THREAD_LOCAL;
    }

    public static void setValue(Integer integer) {
        THREAD_LOCAL.set(integer);
    }

    public static Integer getValue() {
        return THREAD_LOCAL.get();
    }
}
