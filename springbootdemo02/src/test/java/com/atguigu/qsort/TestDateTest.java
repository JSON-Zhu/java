package com.atguigu.qsort;

import com.atguigu.aspect.CountExecutionTime;
import com.atguigu.aspect.CustomThreadLocal;
import com.atguigu.services.NewWork;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.ref.WeakReference;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

/**
 * TestDateTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/5 18:23
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestDateTest extends TestB {

    public TestDateTest() {
        System.out.println("子类构造器");
    }

    static {
        System.out.println("子类static block");
    }

    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = threadLocal();

    private static ThreadLocal<Integer> threadLocal() {
        System.out.println("子类静态变量初始化");
        return new ThreadLocal<>();
    }

    @Autowired
    private TestDate testDate;

    @Test
    public void test2() {

        WeakReference<ThreadLocal<Integer>> threadLocalWeakReference = new WeakReference<>(INTEGER_THREAD_LOCAL);
        //integerThreadLocal = null;
        System.out.println(threadLocalWeakReference.get());
        System.gc();
        System.out.println(threadLocalWeakReference.get());
        //assertNotNull(integerThreadLocal);
    }

    @Test
    public void quickSortV3() {
        int cap = 10000;
        int[] arr = new int[cap];
        for (int i = 0; i < cap; i++) {
            int i1 = new Random().nextInt(100);
            //int i1 = 100;

            arr[i] = i1;
        }
        //log.info("排序前的数组:{}", Arrays.toString(arr));
        //方法:quickSortV3:快速排序耗时:79ms,选择第一个作为pivot,10000个随机元素.
        //方法:quickSortV3:快速排序耗时:121ms,选择第一个作为pivot,10000个相等的元素.
        int[] ints = testDate.quickSortV3(arr, 0, arr.length - 1);
        System.out.println("CustomThreadLocal.getValue() = " + CustomThreadLocal.getValue());
        //方法:quickSortByTextbook:快速排序耗时:5ms,按照三个选中间的原则作为pivot,10000个随机元素.
        //方法:quickSortByTextbook:快速排序耗时:6ms,按照三个选中间的原则作为pivot,10000个相等的元素.
        //int[] ints = testDate.quickSortByTextbook(arr, 0, arr.length - 1);
        //log.info("排序后的数组:{}", Arrays.toString(ints));
    }

    @Test
    public void quickSortV4() {
        int cap = 10000;
        int[] arr = new int[cap];
        for (int i = 0; i < cap; i++) {
            int i1 = new Random().nextInt(100);
            //int i1 = 100;

            arr[i] = i1;
        }
        //log.info("排序前的数组:{}", Arrays.toString(arr));
        //方法:quickSortV3:快速排序耗时:79ms,选择第一个作为pivot,10000个随机元素.
        //方法:quickSortV3:快速排序耗时:121ms,选择第一个作为pivot,10000个相等的元素.
        //int[] ints = testDate.quickSortV3(arr, 0, arr.length - 1);

        //方法:quickSortByTextbook:快速排序耗时:5ms,按照三个选中间的原则作为pivot,10000个随机元素.
        //方法:quickSortByTextbook:快速排序耗时:6ms,按照三个选中间的原则作为pivot,10000个相等的元素.

        //方法:quickSortByTextbook:快速排序耗时:19ms  ,10万数据
        int[] ints = testDate.quickSortByTextbook(arr, 0, arr.length - 1);

        //方法:bubbleSort:快速排序耗时:362ms,10万数据,快速排序查了
        //testDate.bubbleSort(arr);
        log.info("排序后的数组:{}", Arrays.toString(ints));
    }

    @Test
    public void test22() {
        testDate.createRandomNonRepeatNumber(10000, 100000);//方法:createRandomNonRepeatNumber:快速排序耗时:5ms
        testDate.createRandomNonRepeatNumberV2(10000, 100000);//方法:createRandomNonRepeatNumberV2:快速排序耗时:2ms
    }

    @Test
    public void test33() {
        ServiceLoader<NewWork> load = ServiceLoader.load(NewWork.class);
        for (NewWork newWork : load) {
            newWork.connectToNetwork();
        }
        Class<Class> classClass = Class.class;
        for (Class<?> declaredClass : classClass.getDeclaredClasses()) {
            System.out.println("declaredClass.getName() = " + declaredClass.getName());
        }
        ArrayList<Object> objects = new ArrayList<>();

        objects.add(3);
    }

    @Test
    public void test222() {
//        FutureTask<String> stringFutureTask = new FutureTask<>(() -> "hello");
//        stringFutureTask.run();
//        try {
//            System.out.println("stringFutureTask.get() = " + stringFutureTask.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        //Class<TestDateTest> testDateTestClass = TestDateTest.class;
        //TestDateTest testDateTest = new TestDateTest();
//        Class.forName();
//        testDateTest.getClass();
//        testDateTest.getClass().getClassLoader().loadClass();
//        testDate.findAbsentNumberByXOR();
//        testDate.findAbsentNumber();
        testDate.findRepeatNumberByXOR();
    }


}

class TestB {
    static {
        System.out.println("父类static block");
    }

    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = threadLocal();

    private static ThreadLocal<Integer> threadLocal() {
        System.out.println("父类静态变量初始化");
        return new ThreadLocal<>();
    }

    public TestB() {
        System.out.println("父类构造器");
    }
}




