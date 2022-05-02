package com.test.concurrent.threadcomm;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * ObjectMonitor
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/30 3:13
 **/
public class ObjectMonitor {
    public static void main(String[] args) {
        // 创建锁对象（main 方法中没有 this，所以自己创建）
        Object lockObject = new Object();

// 直接打印对象结构
        System.out.println(Thread.currentThread().getName() + " " + ClassLayout.parseInstance(lockObject).toPrintable());

// 加同步代码块，再次打印对象结构
        synchronized (lockObject) {
            System.out.println(Thread.currentThread().getName() + " " + ClassLayout.parseInstance(lockObject).toPrintable());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// 开启一个新的线程申请锁
        new Thread(()->{
            synchronized (lockObject) {
                while (true) {
                    try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {}

                    // 在同步代码块内打印对象结构
                    System.out.println(Thread.currentThread().getName() + " " + ClassLayout.parseInstance(lockObject).toPrintable());
                }
            }
        }, "AAA").start();

        try {
            // 这里等待一会儿是为了让 AAA 线程先在较低的锁级别执行一段时间
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// 开启一个新的线程申请锁
        new Thread(()->{
            synchronized (lockObject) {
                // 新建一个 BBB 线程是为了竞争锁，
                // 但是由于 AAA 线程是 while (true) 执行，永远不会释放锁
                // 所以 BBB 线程内部什么都不用做，只要去竞争就能让 AAA 线程的锁膨胀
            }
        }, "BBB").start();
    }
}
