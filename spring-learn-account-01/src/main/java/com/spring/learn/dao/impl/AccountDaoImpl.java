package com.spring.learn.dao.impl;

import com.spring.learn.dao.IAccountDao;
import com.spring.learn.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层实现类
 */

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public Account findById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) value(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id = ?",accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
