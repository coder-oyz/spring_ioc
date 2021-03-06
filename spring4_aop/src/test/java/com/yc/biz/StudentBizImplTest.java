package com.yc.biz;

import com.yc.MyAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName: StudentBizImplTest
 * @Author: coder-oyz
 * @Date: 2021/4/9 19:09
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyAppConfig.class)
public class StudentBizImplTest {

    @Autowired
    private StudentBiz sbi;

    @Test
    public void add() {
        sbi.add("李四");
    }



    @Test
    public void find() {
        sbi.find("李四");
    }

    @Test
    public void update() {
        sbi.update("李四");
    }
}