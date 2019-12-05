package com.spring.learn.controller;

import com.spring.learn.config.SpringConfiguration;
import com.spring.learn.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Controller {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService service = ac.getBean("service",IAccountService.class);
        service.saveAccount();
        service.updateAccount(1);
        service.deletAccount();
    }
}
