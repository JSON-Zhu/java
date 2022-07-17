package com.atguigu.demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * RedBagDemo
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/9 6:52
 **/
public class RedBagDemo {

    @Test
    public void testBigDecimal(){
        BigDecimal bigDecimal = new BigDecimal(108);
        BigDecimal divisor = new BigDecimal("8.22");
        BigDecimal multiply = bigDecimal.multiply(divisor);
        System.out.println("multiply = " + multiply.round(MathContext.UNLIMITED));
        BigDecimal divide = bigDecimal.divide(divisor, 0, RoundingMode.HALF_EVEN);
        System.out.println(divide);
    }

    @Test
    public void testBigInteger(){
        BigInteger bigInteger = new BigInteger("124546899999999999999999999999999999999999999999");
        BigInteger bigInteger2 = new BigInteger("12454");
        BigInteger divide = bigInteger.multiply(bigInteger2);
        System.out.println("divide = " + divide);
    }

    private static Random random = new Random();

    public static void main(String[] args) {
        long[] longs = generateRedBag(10000, 10, 1, 9999);
        System.out.println(Arrays.toString(longs));

        BigDecimal[] bigDecimals = new BigDecimal[longs.length];

        for (int i = 0; i < longs.length; i++) {
            BigDecimal bigDecimal = new BigDecimal(longs[i]);
            BigDecimal divisor = new BigDecimal(100);
            BigDecimal divide = bigDecimal.divide(divisor, 2, RoundingMode.HALF_EVEN);
             divide = divide.stripTrailingZeros();

            /**
             * BigDecimal divide = bigDecimal.divide(divisor, 2, RoundingMode.UNNECESSARY);
             * [698, 1219, 1, 748, 1267, 1107, 4960]
             * [6.98, 12.19, 0.01, 7.48, 12.67, 11.07, 49.60]
             *
             * scale为4
             * [1643, 1001, 1539, 1580, 1404, 1155, 1678]
             * [16.4300, 10.0100, 15.3900, 15.8000, 14.0400, 11.5500, 16.7800]
             *
             *
             */

            bigDecimals[i]=divide;
        }

        System.out.println(Arrays.toString(bigDecimals));


    }

    public static long[] generateRedBag(long total, int count, long min, long max) {
        long[] result = new long[count];
        //取平均值
        long average = total / count;
        for (int i = 0; i < result.length; i++) {
            //红包大了,往平均线上减
            long randomValue = nextLong(min, max);
            if (randomValue > average) {
                long temp = min + xRandom(min, average);
                result[i] = temp;
                total -= temp;
            } else {
                //红包小了,往平均线上减
                long temp = max - xRandom(average, max);
                result[i] = temp;
                total -= temp;
            }
        }
        //余钱,给不超过最大额的每个人加一块
        while (total > 0) {
            for (int i = 0; i < result.length; i++) {
                if (total > 0 && result[i] < max) {
                    result[i]++;
                    total--;
                }
            }
        }
        //如果小于0,按人头减1
        while (total < 0) {
            for (int i = 0; i < result.length; i++) {
                if (total < 0 && result[i] > min) {
                    result[i]--;
                    total++;
                }
            }
        }
        return result;
    }

    public static long[] generateRedBagV2(long total, int count, long min, long max) {
        long[] result = new long[count];
        //取平均值
        long average = total / count;
        for (int i = 0; i < result.length; i++) {
            //红包大了,往平均线上减
            long randomValue = nextLong(min, max);
            if (randomValue > average) {
                long temp = min + xRandom(min, average);
                result[i] = temp;
                total -= temp;
            } else {
                //红包小了,往平均线上减
                long temp = max - xRandom(average, max);
                result[i] = temp;
                total -= temp;
            }
        }
        //余钱,给不超过最大额的每个人加一块
        while (total > 0) {
            for (int i = 0; i < result.length; i++) {
                if (total > 0 && result[i] < max) {
                    result[i]++;
                    total--;
                }
            }
        }
        //如果小于0,按人头减1
        while (total < 0) {
            for (int i = 0; i < result.length; i++) {
                if (total < 0 && result[i] > min) {
                    result[i]--;
                    total++;
                }
            }
        }
        return result;

    }

    //放大取随机在缩小
    static long xRandom(long min, long max) {
        return sqrt(nextLong(sqr(max - min)));
    }

    static long sqrt(long n) {
        return (long) Math.sqrt(n);
    }

    static long sqr(long n) {
        return n * n;
    }

    static long nextLong(long n) {
        return random.nextInt((int) n);
    }

    //min,max之间的随机数
    static long nextLong(long min, long max) {
        return random.nextInt((int) (max - min + 1)) + min;
    }

    @Test
    public void test2() {
        for (int i = 0; i < 19; i++) {
            System.out.println(nextLong(4, 9));
        }
    }


}
