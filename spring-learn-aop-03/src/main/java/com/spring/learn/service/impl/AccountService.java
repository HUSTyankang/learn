package com.spring.learn.service.impl;

import com.spring.learn.service.IAccountService;

public class AccountService implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("账户保存");
        //int i = 1 / 0;
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("账户更新"+id);
    }

    @Override
    public int deletAccount() {
        System.out.println("账户删除");
        return 0;
    }
}
