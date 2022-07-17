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

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new D02Executors());

        Future<?> submit = threadPoolExecutor.submit(() -> System.out.println("调用runnable方法"));
        System.out.println(submit.get());

        try {
            for (int i = 0; i < 9; i++) {
                int finalI = i;
                //TimeUnit.SECONDS.sleep(1);
                threadPoolExecutor.execute(()-> System.out.println(Thread.currentThread().getName()+" : "+ finalI +"执行了业务逻辑"));
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
