package com.test.enums;

import java.lang.annotation.*;

/**
 * MyAnno
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/20 0:02
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {

    MyAnnotation[] value();

}
