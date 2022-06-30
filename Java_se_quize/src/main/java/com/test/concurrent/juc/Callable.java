package com.test.concurrent.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/28 23:15
 **/
public class Callable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            String s="s2";
            int i=0;
                s="s"+s;
            return "callable interface";
        });

        //new Thread(stringFutureTask,"thread1").start();

        System.out.println(stringFutureTask.get());

        Thread.sleep(100);

        stringFutureTask.cancel(true);
        System.out.println(stringFutureTask.isCancelled());

        //System.out.println(stringFutureTask.isDone());

        try {
            System.out.println(stringFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
