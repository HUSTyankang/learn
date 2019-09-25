package com.spring.learn.dao.impl;

import com.spring.learn.dao.IDao;

public class DaoImpl implements IDao {
    @Override
    public void saveAccount() {
        System.out.println("账户已保存！");
    }
}
