package com.test.concurrent.threadcomm2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/4 17:33
 **/
public class D04CountDownLatch {

    public static void main(String[] args) {

        int stuNum =10;

        CountDownLatch countDownLatch = new CountDownLatch(stuNum);

        for (int i = 0; i < stuNum; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("第:"+ finalI +"个同学离开");
                countDownLatch.countDown();
            },"thread"+i).start();
        }
        try {
            countDownLatch.await();
            System.out.println("锁门成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
