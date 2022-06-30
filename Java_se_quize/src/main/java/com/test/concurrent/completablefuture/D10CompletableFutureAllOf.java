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
public class D10CompletableFutureAllOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future01 = CompletableFuture.supplyAsync(() -> {

            System.out.println("任务 1 开始");
            try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
            System.out.println("任务 1 结束");

            return "task01 result";
        });

        CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {

            System.out.println("任务 2 开始");
            try {
                TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {}
            System.out.println("任务 2 结束");

            return "task02 result";
        });

        CompletableFuture<String> future03 = CompletableFuture.supplyAsync(() -> {

            System.out.println("任务 3 开始");
            try {
                TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {}
            System.out.println("任务 3 结束");

            return "task03 result";
        });

// allOf 方法用来汇总各个任务
        CompletableFuture<Void> future = CompletableFuture.allOf(future01, future02, future03);

// 调用 allOf 方法后返回一个 CompletableFuture 对象，调用这个对象的 get() 方法能够启动汇总的各个任务的线程
        System.out.println("all of future 的 get() 方法开始");

// 所有具体任务线程结束后，get() 方法结束阻塞，但是不返回任何结果。
        Void nullResult = future.get();
        System.out.println("all of future 的 get() 方法结束");

        System.out.println("nullResult = " + nullResult);

// 如果需要各个具体任务各自的结果，那就调用各自的 get() 方法
        String task01Result = future01.get();
        System.out.println("task01Result = " + task01Result);

        String task02Result = future02.get();
        System.out.println("task02Result = " + task02Result);

        String task03Result = future03.get();
        System.out.println("task03Result = " + task03Result);

    }
}
