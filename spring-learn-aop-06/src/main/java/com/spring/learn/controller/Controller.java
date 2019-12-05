package com.spring.learn.controller;

import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("service",IAccountService.class);
//        service.transfer("yyy","kkk",100f);
        List<Account> accounts = service.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
