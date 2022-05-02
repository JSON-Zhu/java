package com.test.javaee;

import java.util.concurrent.locks.Lock;

/**
 * SleepWait
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/26 21:57
 **/
public class SleepWait {

    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args) throws InterruptedException {

        // 1、创建一个普通的对象，用来作为同步锁的锁对象
        Object lock = new Object();

        lock.wait();

        // 2、创建 A 线程
        new Thread(()->{

            // 使用 synchronized 设定一个同步代码块
            // 线程必须获取到锁才能执行同步代码块中的代码
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始了");

                    Thread.sleep(5000);

                    System.out.println(Thread.currentThread().getName() + " 结束了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "thread-a").start();

        Thread.sleep(1000);

        // 3、创建 B 线程
        new Thread(()->{

            // 使用 synchronized 设定一个同步代码块
            // 线程必须获取到锁才能执行同步代码块中的代码
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始了");
                System.out.println(Thread.currentThread().getName() + " 结束了");
            }

        }, "thread-b").start();

    }
}
