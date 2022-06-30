package com.bloomfilter;

import java.util.BitSet;

/**
 * BloomTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/10 23:15
 **/
public class BloomFilterTest {
    //初始化bitmap大小
    private static final Integer DEFAULT_SIZE = 2 ;
    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};

    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    //设置 hash 函数数量
    private static HashFunction[] functions = new HashFunction[seeds.length];

    //添加数据
    public static void put(String value) {
        if (value != null) {
            for (HashFunction function : functions) {
                //计算hash值,并修改bitmap中对应位置为true
                bitset.set(function.hash(value), true);
            }
        }
    }

    //判断是否存在
    public static boolean check(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction function : functions) {
            ret = bitset.get(function.hash(value));
            if(!ret)
                break;
        }
        return ret;
    }

    public static void main(String[] args) {
        String value="test";
        String value2="test1";
        String value3="test2";
        String value4="test3";
        String value5="test4";
        for (int i = 0; i < seeds.length; i++) {
            functions[i]=new HashFunction(DEFAULT_SIZE,seeds[i]);
        }
        put(value);
        put(value2);
        put(value3);
        put(value4);
        put(value5);
        System.out.println(check("test"));
        System.out.println(check("test1"));
        System.out.println(check("test2"));
        System.out.println(check("test3"));
        System.out.println(check("test4"));
    }
}

class HashFunction {

    private int size;
    private int seed;

    public HashFunction(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        int r = (size - 1) & result;
        return (size - 1) & result;
    }
    public static int[] quickSortV2(int[] arr, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            int pivot = arr[low];
            while (left != right) {
                while (arr[right] >= arr[low] && left < right)
                    right--;
                while (arr[left] < arr[low] && left < right)
                    left++;
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            int temp = arr[low];
            arr[low] = arr[right];
            arr[right] = temp;
            quickSortV2(arr, low, right - 1);
            quickSortV2(arr, right + 1, high);
        }
        return arr;
    }
}
