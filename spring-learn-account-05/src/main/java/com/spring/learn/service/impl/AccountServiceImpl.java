package com.spring.learn.service.impl;

import com.spring.learn.dao.IAccountDao;
import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import com.spring.learn.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制都是在业务层
 */
@Service("service")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private TransactionManager txManager;


    public List<Account> findAll() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }

    }

    public Account findById(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }

    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            txManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            txManager.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            //2.1.查询转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            //2.2.查询转入账户
            Account targetAccount = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            //2.4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //2.5.更新转出账户
            accountDao.updateAccount(sourceAccount);
            //int i = 1 / 0;
            //2.6.更新转入账户
            accountDao.updateAccount(targetAccount);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            txManager.release();
        }
    }
}
