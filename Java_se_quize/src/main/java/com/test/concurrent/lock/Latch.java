package com.test.concurrent.lock;

import java.util.concurrent.CountDownLatch;

/**
 * Latch
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/3 6:42
 **/
public class Latch {

    public CountDownLatch countDownLatch = new CountDownLatch(8);

}
