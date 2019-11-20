package com.spring.learn.controller;


import com.spring.learn.dao.IDao;
import com.spring.learn.service.IService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {

    public static void main(String[] args) {

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IService service = ac.getBean("service",IService.class);
        IService service2 = ac.getBean("service",IService.class);
        System.out.println(service);
        System.out.println(service == service2);
        service.saveAccount();
        ac.close();

//        IDao dao = ac.getBean("dao", IDao.class);
//        System.out.println(dao);
    }
}
