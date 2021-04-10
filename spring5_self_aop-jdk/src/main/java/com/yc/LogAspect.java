package com.yc;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: LogAspect
 * @Author: coder-oyz
 * @Date: 2021/4/9 20:12
 */

public class LogAspect implements InvocationHandler {
    //1.必须持有目标类引用
   private Object target;

   public LogAspect(Object target){
       this.target = target;
   }

   //2.生成唯一一个代理实例
   public Object createProxy(){
       return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
   }

    //3. 回调
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类对象："+proxy.getClass());
        System.out.println("方法："+method);
        System.out.println("方法中的参数："+args);

        //4.增强
        //前置增强
        doBefore();

        Object returnVal = method.invoke(this.target,args);

        //后置增强
        doAfter();
        return returnVal;
    }


    private  void doBefore(){
        System.out.println("before : log");
        System.out.println("time: "+ new Date());
    }


    private  void doAfter(){
        System.out.println("after : log");
        System.out.println("time: "+ new Date());
    }
}
