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
public class RWLockWriteOnly {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void readInMultiThreads(){
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始执行写操作");

            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " 结束执行写操作");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public void readInSingleThreads(){
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始执行写操作");

            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}

            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + " 开始执行读操作");
                System.out.println(Thread.currentThread().getName() + " 结束执行读操作");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                readLock.unlock();
            }


            System.out.println(Thread.currentThread().getName() + " 结束执行写操作");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        RWLockWriteOnly rwLock = new RWLockWriteOnly();
        //多线程下,写锁不共享
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                rwLock.read();
//            },"thread-"+i).start();
//        }
        rwLock.readInSingleThreads();

    }

}
