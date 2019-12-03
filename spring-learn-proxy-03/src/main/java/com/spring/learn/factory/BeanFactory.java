package com.spring.learn.factory;

import com.spring.learn.service.IAccountService;
import com.spring.learn.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    private IAccountService accountService;

    @Autowired
    private TransactionManager txManager;

    @Autowired
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Bean(name = "proxyAccountService")
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
