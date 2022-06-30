package com.test.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * D01CompletableFutureTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/5 6:42
 **/
public class D07CompletableFutureComplete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //future.complete() 从其他提前获取结果. completableFuture线程会中断执行

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{

            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " is working");
                try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
            }

            return "original result";
        });

        new Thread(()->{

            try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {}

            // 在另一个线程中结束执行任务的原本那个线程
            boolean finishResult = future.complete("new result from another way");

            System.out.println("finishResult = " + finishResult);

        }).start();

        String finalResult = future.get();

        System.out.println("finalResult = " + finalResult);

    }
}
