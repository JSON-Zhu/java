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
public class D08CompletableFutureException {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //任务抛出异常时调用exceptionally
            //参数 throwable

        String s = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个任务");
            return "first task result";
        }).thenApply((String prevTaskResult) -> {
            System.out.println("第二个任务 " + (10 / 0));
            return prevTaskResult;
        }).exceptionally((Throwable t) -> {
            String exceptionFullName = t.getClass().getName();
            System.out.println("exceptionFullName = " + exceptionFullName);

            Throwable cause = t.getCause();
            System.out.println("cause.getClass().getName() = " + cause.getClass().getName());

            System.out.println("t.getMessage() = " + t.getMessage());
            return "前面任务抛出异常";
        }).get();

        System.out.println("s = " + s);


    }
}
