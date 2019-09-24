package com.spring.learn.controller;

import com.spring.learn.factory.BeanFactory;
import com.spring.learn.service.IService;
import com.spring.learn.service.impl.ServiceImpl;

public class Controller {
    /**
     * 使用new关键字引入依赖的对象，当依赖的类不存在时在编译期就会报错
     * 实际开发中要做到在编译期不依赖，在运行期才依赖
     */

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IService iService = (IService)BeanFactory.getBean("service");
            System.out.println(iService);
            iService.saveAccount();
        }
    }
}
