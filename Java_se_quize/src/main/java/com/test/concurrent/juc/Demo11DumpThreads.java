package com.test.concurrent.juc;

import java.util.concurrent.TimeUnit;

/**
 * DumpThread
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/29 18:31
 **/
public class Demo11DumpThreads {

    public static void main(String[] args) {

        // 1、查看线程的就绪状态
        new Thread(()->{
            while (true){}
        }, "thread-show-runnable").start();

        // 2、查看线程的等待状态（睡美人）
        new Thread(()->{
            synchronized (Demo11DumpThreads.class) {
                try {
                    // 这里调用 wait() 方法让当前线程进入等待状态，如果没有别的线程来唤醒，
                    // 那么这个线程就将一直等待下去
                    Demo11DumpThreads.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "thread-show-waiting").start();

        // 3、查看阻塞状态
        new Thread(()->{

            synchronized (Demo11DumpThreads.class) {
                try {
                    TimeUnit.SECONDS.sleep(100);} catch (InterruptedException e) {}
            }

        }, "thread-show-timed-waiting").start();

        new Thread(()->{

            synchronized (Demo11DumpThreads.class) {
                while (true) {}
            }

        }, "thread-show-blocked").start();



    }

}
