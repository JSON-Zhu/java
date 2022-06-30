package com.test.javaee;

/**
 * For
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 9:45
 **/
public class For {

    public static void main(String[] args) {

        Integer[] test = new Integer[]{1, 2, 3, 4, 5,};

        int[] test2 = {1, 2, 3, 4, 5};
        for (int i : test2) {
            i = i * 2;
            System.out.println(i);
        }
        for (int i : test2) {
            System.out.println(i);
        }


    }

}
