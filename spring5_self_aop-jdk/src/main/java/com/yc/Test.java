package com.yc;

import com.yc.biz.StudentBiz;
import com.yc.biz.StudentBizImpl;

/**
 * @ClassName: Test
 * @Author: coder-oyz
 * @Date: 2021/4/10 19:32
 */
public class Test {
    public static void main(String[] args) {
        StudentBiz target = new StudentBizImpl();

        LogAspect la = new LogAspect(target);

        Object obj = la.createProxy();

        if(obj instanceof  StudentBiz){
            StudentBiz sb = (StudentBiz) obj;
            sb.find("张三");
            sb.add("李四");
            sb.update("王老五");
        }
        System.out.println(obj);
    }
}
