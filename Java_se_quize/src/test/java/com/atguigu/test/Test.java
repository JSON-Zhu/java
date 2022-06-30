package com.atguigu.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Test
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/28 17:52
 **/
public class Test {
    public static void main(String[] args) {
        FutureTask<String> objectFutureTask = new FutureTask<>(() -> Thread.currentThread().getName()+"::"+"test");
        new Thread(objectFutureTask).start();
        try {
            System.out.println(objectFutureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
