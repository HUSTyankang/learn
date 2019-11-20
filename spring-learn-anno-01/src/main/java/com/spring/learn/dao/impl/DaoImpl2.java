package com.spring.learn.dao.impl;

import com.spring.learn.dao.IDao;
import org.springframework.stereotype.Repository;

@Repository("dao2")
public class DaoImpl2 implements IDao {
    public void saveAccount() {
        System.out.println("账户已保存2222！");
    }
}
