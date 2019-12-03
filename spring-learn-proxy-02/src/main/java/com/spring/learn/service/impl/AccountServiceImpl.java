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
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public List<Account> findAll() {
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    public Account findById(Integer accountId) {
        Account account = accountDao.findById(accountId);
        return account;
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {

            //1.查询转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            //2.查询转入账户
            Account targetAccount = accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            //4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //5.更新转出账户
            accountDao.updateAccount(sourceAccount);
            int i = 1 / 0;
            //6.更新转入账户
            accountDao.updateAccount(targetAccount);
    }
}
