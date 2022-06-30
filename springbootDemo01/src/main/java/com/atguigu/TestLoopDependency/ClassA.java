package com.atguigu.TestLoopDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassBA
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/20 13:27
 **/
@Component
public class ClassA {
    @Autowired
    private ClassB classB;

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
@Component
class ClassB {
    @Autowired
    private ClassA classA;

    public ClassA getClassA() {
        return classA;
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
