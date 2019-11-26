package com.spring.learn.dao;

import com.spring.learn.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 根据id查询一个账户
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 跟新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据账户名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
