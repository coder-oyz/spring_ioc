package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: StudentBiz
 * @Author: coder-oyz
 * @Date: 2021/4/9 20:21
 */
public interface StudentBiz {

    public int add(String name) ;

    public void update(String name) ;

    public void find(String name);
}
