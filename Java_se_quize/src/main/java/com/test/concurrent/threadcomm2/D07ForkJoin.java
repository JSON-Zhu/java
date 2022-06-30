package com.test.concurrent.threadcomm2;

import java.util.concurrent.*;

/**
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/4 17:33
 **/
public class D07ForkJoin extends RecursiveTask<Integer> {

    private int begin;
    private int end;

    public static final int ADJUST_VALUE =10;

    private int result=0;

    public D07ForkJoin(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if (end-begin<ADJUST_VALUE) {
            for (int i = begin; i <=end ; i++) {
                result +=i;
            }
        }else {
            int leftBegin=begin;
            int leftEnd=(begin+end)/2;
            int rightBegin=leftEnd+1;
            int rightEnd=end;
            D07ForkJoin d07ForkJoinLeft = new D07ForkJoin(leftBegin, leftEnd);
            d07ForkJoinLeft.fork();
            D07ForkJoin d07ForkJoinRight = new D07ForkJoin(rightBegin, rightEnd);
            d07ForkJoinRight.fork();

            Integer join = d07ForkJoinLeft.join();
            Integer join1 = d07ForkJoinRight.join();
            result=join+join1;
        }
        return result;
    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        D07ForkJoin d07ForkJoin = new D07ForkJoin(1, 10000);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(d07ForkJoin);

        try {
            Integer integer = submit.get();
            System.out.println("sum ="+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
