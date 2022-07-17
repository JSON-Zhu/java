package com.test.concurrent.threadcomm;

import org.junit.Test;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Notify
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/30 0:01
 **/
public class Notify {

    private Integer num = 0;

    public void add() {
        try {
            synchronized (this) {
                while (num > 0) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + ":" + (++num));
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sub() {
        try {
            synchronized (this) {
                while (num == 0) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + ":" + (--num));
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Notify notify = new Notify();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.add();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-add").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.sub();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-sub").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.add();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-add2").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.sub();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-sub2").start();

    }

    @Test
    public void test3() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行runnable方法");
        }, "thread-1");
        thread.start();
        thread.interrupt();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("中断异常");
            e.printStackTrace();
        }
    }

    @Test
    public void test34() {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行runnable方法");
        }, "thread-1");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待thread执行完成");
            }
        });


        thread.start();
        thread1.start();
    }

    @Test
    public void test54(){
        int[] ints = new int[100];
    }

}
