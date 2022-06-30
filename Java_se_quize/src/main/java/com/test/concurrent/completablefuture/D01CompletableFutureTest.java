package com.test.concurrent.completablefuture;

import sun.misc.Unsafe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * D01CompletableFutureTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/5 6:42
 **/
public class D01CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() +":"+ finalI + ":test");
            });
            voidCompletableFuture.get();
        }
        
    }
}
