package com.test.concurrent.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/29 2:33
 **/
public class Executor {
    public static void main(String[] args) {

        ExecutorService executorPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 80; i++) {
            int finalI = i;
            executorPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + ":" + finalI);
            });
        }

        List list = new ArrayList<>();
        list.add(1);
        list.add(2);

        list.parallelStream().forEach((i)->{
            System.out.println(i);
        });
    }
}
