package com.yc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @ClassName: LogAspect
 * @Author: coder-oyz
 * @Date: 2021/4/9 20:12
 */

public class LogAspectCglib implements MethodInterceptor {
    //1.必须持有目标类引用
   private Object target;

   public LogAspectCglib(Object target){
       this.target = target;
   }

   //2.生成唯一一个代理实例
   public Object createProxy(){
       Enhancer enhancer = new Enhancer();
       enhancer.setSuperclass(this.target.getClass());
       enhancer.setCallback(this);
       return enhancer.create();
   }


    private  void doBefore(){
        System.out.println("before : log");
        System.out.println("time: "+ new Date());
    }


    private  void doAfter(){
        System.out.println("after : log");
        System.out.println("time: "+ new Date());
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("代理类对象："+obj.getClass());
        System.out.println("目标类的方法："+method);
        System.out.println("方法中的参数："+args);
        System.out.println("要代理类的方法："+proxy);

        //4.增强
        //前置增强
        doBefore();

        Object returnVal = method.invoke(this.target,args);

        //后置增强
        doAfter();
        return returnVal;
    }
}
