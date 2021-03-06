package com.spring.learn.service;

import com.spring.learn.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */

public interface IAccountService {
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
     * 转账
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money         转账金额
     */
    void transfer(String sourceName, String targetName, Float money);


}
