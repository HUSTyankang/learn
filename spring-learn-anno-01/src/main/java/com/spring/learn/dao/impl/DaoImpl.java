package com.spring.learn.dao.impl;

import com.spring.learn.dao.IDao;
import org.springframework.stereotype.Repository;

@Repository("dao1")
public class DaoImpl implements IDao {
    public void saveAccount() {
        System.out.println("账户已保存！");
    }
}
