package com.spring.learn.controller;

import com.spring.learn.service.IService;
import com.spring.learn.service.impl.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //使用构造方法注入
        IService service = ac.getBean("service",IService.class);
        service.saveAccount();
        //使用set方法注入
        IService serviceSet = (IService) ac.getBean("service_set");
        serviceSet.saveAccount();
        //复杂类型注入
        IService service3 = (IService) ac.getBean("service3");
        service3.saveAccount();

    }
}
