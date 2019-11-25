package com.spring.learn.service.impl;

import com.spring.learn.dao.IAccountDao;
import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("service")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
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
        accountDao.transfer(sourceName, targetName,100f);
    }


}
