package com.test.concurrent.jmmlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * D01AtomicInt
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/6 8:07
 **/
public class D02AtomicIntVsSynchronized {

    private AtomicInteger data = new AtomicInteger(0);

    public void add(){
        data.incrementAndGet();
    }


    public static void main(String[] args) {

        D02AtomicIntVsSynchronized demo = new D02AtomicIntVsSynchronized();

        // 创建第一个线程执行累加操作
        new Thread(()->{
            long startExecutingTime = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                demo.add();
            }
            long endExecutingTime = System.currentTimeMillis();
            System.out.println("usedTime=" + (endExecutingTime-startExecutingTime));
        }, "thread-01").start();

        // 创建第二个线程执行累加操作
        new Thread(()->{
            long startExecutingTime2 = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                demo.add();
            }
            long endExecutingTime2 = System.currentTimeMillis();
            System.out.println("usedTime=" + (endExecutingTime2-startExecutingTime2));
        }, "thread-02").start();
    }

}
