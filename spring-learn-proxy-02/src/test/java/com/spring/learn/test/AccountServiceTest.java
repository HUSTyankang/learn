package com.spring.learn.test;


import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    IAccountService iAccountService;

    @Test
    public void testTransfer(){
        iAccountService.transfer("yyy","kkk",100f);
        System.out.println("转账成功！！");
    }


    @Test
    public void testFindAll() {
        List<Account> accounts = iAccountService.findAll();
        for (Account each : accounts) {
            System.out.println(each);
        }
    }

}
