package com.test.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * D01CompletableFutureTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/5 6:42
 **/
public class D06CompletableFutureCombine {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //combine合并多个任务的结果

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName()+" 1st task result";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName()+ " 2nd task result";
        });

        CompletableFuture<String> future = future1.thenCombine(future2, (String first, String second) -> {
            return first + second;
        });

        String s = future.get();

        System.out.println("s = " + s);

    }
}
