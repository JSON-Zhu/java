package com.test.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * FairLock
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/1 20:12
 **/
public class FairLock {
    private Lock lock = new ReentrantLock(false);

    public void printMessage() {

        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " say hello to you");
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printMessage2() {
        boolean b = false;
        try {
            b = lock.tryLock(1, TimeUnit.SECONDS);
            if (b){
                System.out.println("tryLock成功");
            }else {
                System.out.println("tryLock失败");
            }
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (b) {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        // 1、创建当前类的对象
        FairLock demo = new FairLock();



        // 2、创建三个线程，每个线程内调用 printMessage() 方法十次
        new Thread(() -> {


            demo.printMessage();


        }, "thread-a").start();


        new Thread(() -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            demo.printMessage2();


        }, "thread-b").start();

        new Thread(() -> {
//            try {
//                thread1.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            demo.printMessage2();


        }, "thread-c").start();

    }
}
