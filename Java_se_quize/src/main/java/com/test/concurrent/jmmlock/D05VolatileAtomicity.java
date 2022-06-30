package com.test.concurrent.jmmlock;

import java.util.concurrent.TimeUnit;

/**
 * D01AtomicInt
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/6 8:07
 **/
public class D05VolatileAtomicity {
    private volatile int data = 0;

    public void add() {
        System.out.println(Thread.currentThread().getName() + " data = " + ++data);
    }

    public static void main(String[] args) {

        D05VolatileAtomicity demo = new D05VolatileAtomicity();

        new Thread(()->{

            for (int i = 0; i < 100; i++) {
                try {TimeUnit.MILLISECONDS.sleep(10);} catch (InterruptedException e) {}
                demo.add();
            }

        }, "AAA").start();

        new Thread(()->{

            for (int i = 0; i < 100; i++) {
                try {TimeUnit.MILLISECONDS.sleep(10);} catch (InterruptedException e) {}
                demo.add();
            }

        }, "BBB").start();

    }

}
