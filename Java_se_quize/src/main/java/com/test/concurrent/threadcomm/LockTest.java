package com.test.concurrent.threadcomm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/30 17:15
 **/
public class LockTest {

    private int stock = 100;

    private int sellCount = 0;

    private Lock lock = new ReentrantLock();

    public void sellTicket() {
        try {
            lock.wait();
            lock.lock();
            if (stock > 0) {
                System.out.println(Thread.currentThread().getName()+"剩余:" + --stock + "张票");
                sellCount++;
            } else {
                System.out.println("一共卖了:" + sellCount + "张票");
                System.out.println(Thread.currentThread().getName()+"票卖完了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        LockTest lockTest = new LockTest();

        //方法内部类
        class p extends Thread {
            @Override
            public void run() {
            }
        }

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                lockTest.sellTicket();
                LockTest lockTest1 = new LockTest();
            }
        },"thread-a").isInterrupted();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                lockTest.sellTicket();
            }
        },"thread-b").start();

    }

}
