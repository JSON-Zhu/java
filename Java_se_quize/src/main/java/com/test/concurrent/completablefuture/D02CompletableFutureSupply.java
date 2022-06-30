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
public class D02CompletableFutureSupply {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " is working");
            return "supplyAsync";
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName()+" is behind");
        });

    }
}
