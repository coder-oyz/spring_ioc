package com.yc;

import com.yc.biz.StudentBizImpl;

/**
 * @ClassName: Test
 * @Author: coder-oyz
 * @Date: 2021/4/10 19:57
 */
public class Test {
    public static void main(String[] args) {
        StudentBizImpl sbi = new StudentBizImpl();

        LogAspectCglib lc = new LogAspectCglib(sbi);

        Object obj = lc.createProxy();
        System.out.println(obj);
        if(obj instanceof StudentBizImpl){
            StudentBizImpl s = (StudentBizImpl) obj;

            s.find("张三");
            s.add("张三");
            s.update("张三");
        }

    }
}
