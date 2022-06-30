package com.test.concurrent.jmmlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * D01AtomicInt
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/6 8:07
 **/
public class D03AtomicIntVsSynchronized {
    private int data = 0;

    public synchronized void add() {
        data++;

    }

    public static void main(String[] args) {
        D03AtomicIntVsSynchronized demo = new D03AtomicIntVsSynchronized();

        new Thread(() -> {

            long beginTime = System.currentTimeMillis();

            for (int i = 0; i < 20000000; i++) {
                demo.add();
            }

            long endTime = System.currentTimeMillis();

            long usedTime = endTime - beginTime;

            System.out.println(Thread.currentThread().getName() + " usedTime = " + usedTime);

        }, "thread-01").start();

//        new Thread(() -> {
//
//            long beginTime = System.currentTimeMillis();
//
//            for (int i = 0; i < 10000000; i++) {
//                demo.add();
//            }
//
//            long endTime = System.currentTimeMillis();
//
//            long usedTime = endTime - beginTime;
//
//            System.out.println(Thread.currentThread().getName() + " usedTime = " + usedTime);
//
//        }, "thread-02").start();
    }
}
