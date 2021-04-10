package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Log3Aspect
 * @Author: coder-oyz
 * @Date: 2021/4/10 18:59
 */
@Aspect
@Component
@Order(value = 1)
public class Log3Aspect {
    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("compute2进到了增强。。。");
        long start = System.currentTimeMillis();
        Object reVal = pjp.proceed(); //目标类的目标方法
        long end = System.currentTimeMillis();
        System.out.println("compute2 要退出了");
        System.out.println("运行市场"+ (end-start));
        return reVal;
    }
}
