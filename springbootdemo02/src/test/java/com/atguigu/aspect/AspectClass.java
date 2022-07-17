package com.atguigu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * AspectClass
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/5 17:48
 **/
@Component
@Aspect
@Slf4j
public class AspectClass {

    @Around("@annotation(com.atguigu.aspect.CountExecutionTime)")
    public Object timeCount(ProceedingJoinPoint point){
        Object object=null;
        Object[] args = point.getArgs();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String methodName = methodSignature.getMethod().getName();
        CountExecutionTime annotation = methodSignature.getMethod().getAnnotation(CountExecutionTime.class);
        long start = System.currentTimeMillis();
        try {
            object = point.proceed(args);
            long end = System.currentTimeMillis();
            CustomThreadLocal.setValue((int) (end-start));
            log.info("方法:{}:耗时:{}ms",methodName,end-start);
        } catch (Throwable throwable) {
            log.error("代理方法执行错误");
        }
        return object;
    }
}
