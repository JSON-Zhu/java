package com.atguigu.services.impl;

import com.atguigu.services.NewWork;

/**
 * NewWorkImpl2
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/7 0:31
 **/
public class NewWorkImpl2 implements NewWork {
    @Override
    public void connectToNetwork() {
        System.out.println("network实现类2");
    }
}
