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
public class D11CompletableFutureAnyOf {

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

// 汇总各个具体任务
        CompletableFuture<Object> future = CompletableFuture.anyOf(future01, future02, future03);

        System.out.println("总的 get() 方法开始了");
// 在各个具体任务中有任何一个返回，汇总得到的 future 对象的 get() 方法就会返回
// 而且返回的是当前完成的任务的返回值
// 其它没有完成的任务不再继续执行
        Object summaryResult = future.get();
        System.out.println("总的 get() 方法结束了");

        System.out.println("summaryResult = " + summaryResult);

// 如果想要其它任务的结果，需要调用其它任务的 get() 方法
        String task01Result = future01.get();
        System.out.println("task01Result = " + task01Result);

        String task02Result = future02.get();
        System.out.println("task02Result = " + task02Result);

        String task03Result = future03.get();
        System.out.println("task03Result = " + task03Result);
    }
}
