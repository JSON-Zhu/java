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
public class D03CompletableFutureAccept {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Void aVoid = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " is working");
            return "supplyAsync";
        }).thenAccept((String s) -> {
            System.out.println("s = " + s);
        }).get();

        System.out.println("aVoid = " + aVoid);

    }
}
