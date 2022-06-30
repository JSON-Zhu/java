package com.test.concurrent.threadcomm2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * D01ConditionComm
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/4 17:33
 **/
public class D02ConditionComm {

    private Lock lock = new ReentrantLock();

    private Condition digitalCondition = lock.newCondition();
    private Condition charCondition = lock.newCondition();
    private Condition asteriskCondition = lock.newCondition();
    private Condition dollarSignCondition = lock.newCondition();

    private  int printStatus = 1;

    private int digital=1;

    private char firstLetter='a';

    public void printDigital(){
        try {
            lock.lock();
            while (printStatus%4!=1){
                digitalCondition.await();
            }
            System.out.print(digital++);
            //更新状态标识符, 开始下个字符打印
            printStatus++;
            TimeUnit.SECONDS.sleep(1);
            charCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printChar(){
        try {
            lock.lock();
            while (printStatus%4!=2){
                charCondition.await();
            }
            System.out.print(firstLetter++);
            //更新状态标识符, 开始下个字符打印
            printStatus++;
            TimeUnit.SECONDS.sleep(1);
            asteriskCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printAsterisk(){
        try {
            lock.lock();
            while (printStatus%4!=3){
                asteriskCondition.await();
            }
            System.out.print("*");
            //更新状态标识符, 开始下个字符打印
            printStatus++;
            TimeUnit.SECONDS.sleep(1);
            dollarSignCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printDollarSign(){
        try {
            lock.lock();
            while (printStatus%4!=0){
                dollarSignCondition.await();
            }
            System.out.println("$");
            //更新状态标识符, 开始下个字符打印
            printStatus++;
            TimeUnit.SECONDS.sleep(1);
            digitalCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        D02ConditionComm d01ConditionComm = new D02ConditionComm();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.printDigital();
            }
        },"thread1").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.printAsterisk();
            }
        },"thread2").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.printChar();
            }
        },"thread3").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                d01ConditionComm.printDollarSign();
            }
        },"thread4").start();
    }

}
