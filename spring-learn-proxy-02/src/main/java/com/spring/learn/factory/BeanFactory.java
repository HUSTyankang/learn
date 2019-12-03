package com.spring.learn.factory;

import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import com.spring.learn.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),accountService.getClass().getInterfaces(),
                (InvocationHandler)(proxy,method,args)->{
                Object returnValue = null;
                try {
                    //1.开启事务
                    txManager.beginTransaction();
                    //2.执行操作
                    returnValue = method.invoke(accountService,args);
                    //3.提交事务
                    txManager.commit();
                    //4.返回结果
                    return returnValue;
                }catch (Exception e){
                    //5.回滚操作
                    txManager.rollback();
                    throw new RuntimeException(e);
                }finally {
                    //6.释放连接
                    txManager.release();
                }
            });
    }
}
