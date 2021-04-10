package com.yc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: LogAspect
 * @Author: coder-oyz
 * @Date: 2021/4/9 20:12
 */
@Aspect        //切面类
@Component  //托管
@Order(value = 10)
public class Log2Aspect {

    //切入点的声明
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void add(){

    }
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))")
    private void update(){

    }
    @Pointcut("add() || update()")
    private void doLogPointcut(){

    }
    @Before("doLogPointcut()")
    private void doLog(){
        System.out.println("=======前置增强的日志==========");
        System.out.println("方法开始的时间："+System.currentTimeMillis());
        Date d =new Date();
        System.out.println("方法结束的时间:"+System.currentTimeMillis());
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        String time =format.format(d);
        System.out.println("执行时间："+time);
        System.out.println("=========前置增强的日志结束=======");
    }

    @After("update()")      //spring是一个ioc容器，它可以使用 di将程序运行的信息注入
    private void bye( JoinPoint jp){
        System.out.println("===bye===");
        //连接点的所有的信息
        Object target = jp.getTarget();
        System.out.println("目标类为："+target);
        System.out.println("方法："+jp.getSignature());
        Object [] objects =jp.getArgs();
        for(Object o:objects){
            System.out.println("参数："+o);
        }

    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    private Object comput(ProceedingJoinPoint pjp) throws Throwable {
        long start =System.currentTimeMillis();
        System.out.println("方法开始的时间："+start);
        Object retVal =pjp.proceed();
        long end =System.currentTimeMillis();
        System.out.println("方法结束的时间："+end);
        System.out.println("这个方法运行的时长为："+(end-start));
        return retVal;
    }



}
