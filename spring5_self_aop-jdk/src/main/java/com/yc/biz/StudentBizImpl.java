package com.yc.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: TestSpring
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-04-04 14:49
 */
@Service//给spring的类托管
public class StudentBizImpl implements StudentBiz{

    public StudentBizImpl() {
    }



    @Override
    public int add(String name) {
        System.out.println("add 方法");
        return 0;
    }

    @Override
    public void update(String name) {
        System.out.println("update 方法");
    }

    @Override
    public void find(String name) {
        System.out.println("find 方法");
    }
}
