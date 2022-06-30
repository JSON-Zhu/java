package com.test.concurrent.completablefuture;

import com.test.concurrent.juc.Executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * D01CompletableFutureTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/5 6:42
 **/
public class D09CompletableFutureHandle {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //handle(),相当于finally. 如果没有异常,throwable参数为null.

        String s = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个任务");
            return "first task result";
        }).thenApply((String prevTaskResult) -> {
            System.out.println("第二个任务 " );
            return prevTaskResult;
        }).handle((String string, Throwable t) -> {
            if (t!=null) {
                String exceptionFullName = t.getClass().getName();
                System.out.println("exceptionFullName = " + exceptionFullName);

                Throwable cause = t.getCause();
                System.out.println("cause.getClass().getName() = " + cause.getClass().getName());

                System.out.println("t.getMessage() = " + t.getMessage());
                return "前面任务抛出异常";
            }
            return "前面任务执行ok";
        }).get();

        System.out.println("s = " + s);


    }
}
