package com.test.concurrent.threadpool;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Thread
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/7 23:38
 **/
public class D02Executors implements RejectedExecutionHandler {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 0; i < 9; i++) {
                int finalI = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" : "+ finalI +"执行了业务逻辑");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }


    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("系统线程资源耗尽,稍后重试");
    }
}
