package com.spring.learn.factory;

import com.spring.learn.service.IAccountService;
import com.spring.learn.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    //在JDK8之前，如果我们在匿名内部类中需要访问局部变量，那么这个局部变量必须用final修饰符修饰
    //看似是一种编译机制的改变，实际上就是一个语法糖（底层还是帮你加了final）。
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
