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
public class D05CompletableFutureCompose {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //compose的用法,
            //传递前一个任务的返回值
            // 添加更多任务
            // 返回一个completionStage对象

        String s1 = CompletableFuture.supplyAsync(() -> {
            return "first task result";
        }).thenCompose((String preValue) -> {
            return CompletableFuture.supplyAsync(() -> {
                String currentValue = "2st value";
                String s = preValue + currentValue;
                return s;
            });
        }).thenCompose((String prevTaskResult) -> {
            return CompletableFuture.supplyAsync(() -> {

                // 当前任务执行的结果
                String currentTaskResult = "third task result";

                // 将两个任务的结果合并
                String composedTaskResult = prevTaskResult + "@" + currentTaskResult;

                return composedTaskResult;
            });
        }).get();

        System.out.println("s1 = " + s1);

    }
}
