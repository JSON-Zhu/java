package com.atguigu.aspect;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * CountExecutionTime
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/5 17:49
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CountExecutionTime {

}
