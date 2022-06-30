package com.test.designmode;

import org.junit.Test;

/**
 * MaxCommonDivisor
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/22 10:15
 **/
public class MaxCommonDivisor {

    @Test
    public void test() {
        int x = 24;
        int y = 18;
        int z = Math.min(x, y);

        int[] factor = new int[z];

        //最大公约数
        for (int i = z, j = 0; i > 1; i--, j++) {
            if (x % i == 0 && y % i == 0) {
                factor[j] = i;
                break;
            }
        }
        //最小公倍数
        int sum = 1;
        for (int i : factor) {
            if (i != 0) {
                sum = x*y/i;
                System.out.println("sum = " + sum);
            }

        }

    }

}
