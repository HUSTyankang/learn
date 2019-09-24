package com.spring.learn.service.impl;

import com.spring.learn.dao.IDao;
import com.spring.learn.dao.impl.DaoImpl;
import com.spring.learn.factory.BeanFactory;
import com.spring.learn.service.IService;

public class ServiceImpl implements IService {
    //service依赖dao
    private IDao iDao = (IDao) BeanFactory.getBean("dao");
    public void saveAccount() {
        iDao.saveAccount();
    }
}
