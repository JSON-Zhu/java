package com.atguigu.qsort;

import com.atguigu.aspect.CountExecutionTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;

/**
 * TestDate
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 15:49
 **/
@Component
public class TestDate {

    @CountExecutionTime
    public int[] quickSortV3(int[] arr, int left, int right) {
        //递归退出条件
        if (left >= right)
            return arr;
        int pivot = arr[left];
        int low = left;
        int high = right;
        //走到重合下标
        while (low != high) {
            //从右往左开始
            while (low < high && arr[high] >= arr[left]) {
                high--;
            }
            //继而从左往右
            while (low < high && arr[low] < arr[left]) {
                low++;
            }
            //判断是否仍在两边,才可交换
            if (low != high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        //交换pivot和重合位置的值
        int temp2 = arr[left];
        arr[left] = arr[high];
        arr[high] = temp2;
        quickSortV3(arr, left, high - 1);
        quickSortV3(arr, high + 1, right);

        return arr;

    }


    //和网上的快速排序整整20倍的差距啊,数据结构的教授还是厉害啊nb.

    /**
     * 第一: 选择pivot选择策略. 三选一(左,中,右选择中间的)
     * 第二: 与pivot相等的元素,左右都交换
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */

    @CountExecutionTime
    public int[] quickSortByTextbook(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int pivot = determinePivot(arr, left, right);
        int i = left, j = right - 1;
        for (; ; ) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] > pivot) {
            }
            if (i < j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        //i,j相遇
        swap(arr, i, j);
        quickSortByTextbook(arr, left, i - 1);
        quickSortByTextbook(arr, i + 1, right);
        return arr;
    }

    private static int determinePivot(int[] arr, int left, int right) {
        int center = (left + right) >>> 1;
        //比较left, center
        if (arr[left] > arr[center]) {
            swap(arr, arr[left], arr[center]);
        }
        //比较left,right
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        //比较center,right
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        //隐藏pivot
        swap(arr, center, right - 1);
        //返回pivot
        return arr[right - 1];
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    @CountExecutionTime
    public void bubbleSort(int[] arr) {
        //int[] arr = {1, 2, 5, 6, 89, 2};
        //只需要进行length-1次比较
        for (int i = 0; i < arr.length - 1; i++) {
            //每次比较出一个最大值,并使比较的上限下标减去1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @CountExecutionTime
    public void createRandomNonRepeatNumber(int wantedSize, int bound) {
        Set<Integer> integers = new HashSet<>();
        do {
            for (; ; ) {
                int i = new Random().nextInt(bound + 1);
                if (integers.add(i)) {
                    break;
                }
            }
        } while (integers.size() < wantedSize);
        //integers.forEach(System.out::println);
    }

    @CountExecutionTime
    public void createRandomNonRepeatNumberV2(int wantedSize, int bound) {
        int[] ints = new int[bound];
        for (int i = 0; i < bound; i++) {
            ints[i] = i + 1;
        }
        //产生目标数组
        int[] wantedArray = new int[wantedSize];
        Random random = new Random();
        for (int i = 0; i < wantedSize; i++) {
            int index = random.nextInt(bound - i);
            wantedArray[i] = ints[index];
            swap(ints, index, bound - i - 1);
        }
        //System.out.println(Arrays.toString(ints));
        //System.out.println(Arrays.toString(wantedArray));
    }

    @CountExecutionTime
    public void findAbsentNumber() {
        //1000,0000数字耗时:43ms
        int sum = 0;
        for (int i = 1; i < 10000001; i++) {
            sum += i;
        }
        int[] ints = new int[9999999];
        for (int i = 0, j = 1; i < ints.length; i++, j++) {
            if (i == 9999998) {
                ints[i] = i + 2;
                sum = sum - ints[i];
                continue;
            }
            if (i > 0)
                ints[i] = ints[i - 1] + 1;
            else
                ints[0] = 1;
            sum = sum - ints[i];
        }
        System.out.println("sum = " + sum);
    }

    @CountExecutionTime
    public void findAbsentNumberByXOR() {
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum = sum ^ (i + 1);
        }
        int[] ints = new int[9999999];
        for (int i = 0; i < ints.length; i++) {
            if (i == 9999998) {
                ints[i] = i + 2;
                sum = sum ^ ints[i];
                continue;
            }
            if (i > 0)
                ints[i] = ints[i - 1] + 1;
            else
                ints[0] = 1;
            sum = sum ^ ints[i];
        }
        System.out.println("sum = " + sum);
    }

    @CountExecutionTime
    public void findRepeatNumberByXOR() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum ^ (i + 1);
        }
        int[] ints = new int[101];
        for (int i = 0; i < ints.length; i++) {
            if (i == 50) {
                ints[i] = i;
                sum = sum ^ ints[i];
                continue;
            }
            if (i > 0)
                ints[i] = ints[i - 1] + 1;
            else
                ints[0] = 1;
            sum = sum ^ ints[i];
        }
        System.out.println("sum = " + sum);
    }

}

































































































































































