package com.spring.learn.test;

import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService iAccountService = ac.getBean("service",IAccountService.class);
        List<Account> accounts = iAccountService.findAll();
        for (Account each : accounts) {
            System.out.println(each);
        }
    }

    @Test
    public void testFindById() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService iAccountService = ac.getBean("service",IAccountService.class);
        Account account = iAccountService.findById(1);
            System.out.println(account);
    }

    @Test
    public void testSaveAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService iAccountService = ac.getBean("service",IAccountService.class);
        Account account = new Account();
        account.setName("yyy");
        account.setMoney(1000f);
        iAccountService.saveAccount(account);
    }

    @Test
    public void testUpdatAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService iAccountService = ac.getBean("service",IAccountService.class);
        Account account = iAccountService.findById(4);
        account.setName("kkk");
        iAccountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService iAccountService = ac.getBean("service",IAccountService.class);
        iAccountService.deleteAccount(4);
    }
}
