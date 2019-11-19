package com.spring.learn.service.impl;

import com.spring.learn.dao.IDao;
import com.spring.learn.dao.impl.DaoImpl;
import com.spring.learn.service.IService;

public class ServiceImpl implements IService {
    //service依赖dao
    private IDao iDao = new DaoImpl();
    public void saveAccount() {
        iDao.saveAccount();
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象销毁");
    }
}
