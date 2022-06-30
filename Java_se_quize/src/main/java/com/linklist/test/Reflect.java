package com.linklist.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Reflect
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/4 16:22
 **/
public class Reflect {

    public static void main(String[] args) throws Exception {
        int[][][] x = {{{1, 2, 3}, {7, 8, 9}}, {{4, 5, 6}},};

        HashMap<Test, Integer> hashMap = new HashMap<>();
        Test test = new Test("1");
        for (int i = 0; i < 9; i++) {
            hashMap.put(new Test(i+""), i);
        }


    }

    static class Test {
        private String x;

        public Test(String x) {
            this.x = x;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Test test = (Test) o;
//
//            return x != null ? x.equals(test.x) : test.x == null;
//        }

        @Override
        public int hashCode() {
            return 456889;
        }
    }

}
