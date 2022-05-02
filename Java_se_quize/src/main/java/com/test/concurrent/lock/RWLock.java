package com.test.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * RWLock
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/2 0:50
 **/
public class RWLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    public void read(){
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始执行读操作");

            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " 结束执行读操作");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        RWLock rwLock = new RWLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                rwLock.read();
            },"thread-"+i).start();
        }
    }

}
