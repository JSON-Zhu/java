package com.test.concurrent.juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Test
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/12 17:45
 **/
public class Test extends Thread{
    public static void main(String[] args) {
//        String a="aa";
//        String b="bb";
//        String c=a+b;
//        System.out.println(c==(a + b));
//        System.out.println(Thread.currentThread().getName());
//        Thread thread=new Test();
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName()+":"+i*i);
//
//            }
//        }).start();

        HashMap<String, Object> map = new HashMap<>();
        map.put("x","test");
        System.out.println(map.hashCode());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class LockTest{

    public void testLock(){
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock readLock = rwl.readLock();
        readLock.lock();
        try {

        }finally {
            readLock.unlock();
        }
    }
}
