package com.spring.learn.controller;

import com.spring.learn.dao.IDao;
import com.spring.learn.factory.TheClass;
import com.spring.learn.service.IService;
import com.spring.learn.service.impl.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {

    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

//        /**
//         * 使用默认无参构造方法创建对象，没有无参构造方法见创建对象失败
//         */
//
//        //service是Singleton
//        for (int i = 0; i <5 ; i++) {
//            IService service = (IService) ac.getBean("service");
//            System.out.println(service);
//        }
//        //dao是Prototype
//        for (int i = 0; i < 5 ; i++) {
//            IDao dao = (IDao)ac.getBean("dao");
//            System.out.println(dao);
//        }
//
//        /**
//         * 使用静态工厂方法创建对象
//         */
//        TheClass theClass1 = (TheClass)ac.getBean("theClass1");
//        System.out.println(theClass1);
//
//        /**
//         * 使用实例工厂的方法创建对象
//         */
//        TheClass theClass2 = (TheClass)ac.getBean("theClass2");
//        System.out.println(theClass2);


        /**
         * 下面测试bean的生命周期
         * 在单例和多例模式下分别单步调试
         */
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext无法调用子类特有的方法
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//单例模式：当容器创建时对象出生
        IService service = ac.getBean("service",IService.class);//多例模式：当使用对象时spring框架创建
        service.saveAccount();
        ac.close();//手动销毁容器

    }
}
