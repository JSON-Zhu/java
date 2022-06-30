package com.test.concurrent.threadcomm2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * D01ConditionComm
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/4 17:33
 **/
public class D01ConditionComm {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private  int data = 0;

    public void increment(){
        try {
            lock.lock();
            while (data==1){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+" 当前data:"+ ++data);
            TimeUnit.SECONDS.sleep(1);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void subtract(){
        try {
            lock.lock();
            while (data==0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+" 当前data:"+ --data);
            TimeUnit.SECONDS.sleep(1);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        D01ConditionComm d01ConditionComm = new D01ConditionComm();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.increment();
            }
        },"thread1").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.increment();
            }
        },"thread2").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.subtract();
            }
        },"thread3").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.subtract();
            }
        },"thread4").start();
    }

}
