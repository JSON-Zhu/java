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
public class D04CompletableFutureApply {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String s1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " is working");
            return "supplyAsync";
        }).thenApplyAsync((String s) -> {
            System.out.println("s = " + s);
            System.out.println(Thread.currentThread().getName() + " 2 is working");
            return "second task is working";
        }).get();

        System.out.println("s1 = " + s1);

    }
}
