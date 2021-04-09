package com.yc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
public class LogAspect {

    //切入点声明
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void add(){

    }

    //切入点声明
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))")
    private void update(){

    }

    //切入点声明
    @Pointcut("add() || update()")
    private void addAndupdate(){

    }

    @Before("com.yc.aspect.LogAspect.add()")
    public void log(){
        System.out.println("前置增强的日志");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr = sdf.format(d);
        System.out.println("执行时间为"+ dstr);
        System.out.println("前置增强的日志结束");
    }


}
