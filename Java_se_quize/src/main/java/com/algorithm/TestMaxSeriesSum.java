package com.algorithm;

/**
 * TestMaxSeriesSum
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/22 7:39
 **/
public class TestMaxSeriesSum {
    public static void main(String[] args) {
        System.out.println(test4(new int[]{1, 2, -2, 3, 6, -1, -4, 4})); //max 10

        System.out.println("::::::::::::::::::");

        System.out.println(test5(new int[]{1, 2, -2, 3, 6, -1, -4, 4})); //max 10


    }

    public static int test4(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        int ret = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static int test5(int[] arr) {


        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int result = 0;
                for (int k = i; k < j; k++) {
                    result += arr[k];
                }
                if (result > max) {
                    max = result;
                }

            }
        }
        return max;
    }

}
