package com.spring.learn.controller;

import com.spring.learn.service.IService;
import com.spring.learn.service.impl.ServiceImpl;

public class Controller {
    /**
     * 使用new关键字引入依赖的对象，当依赖的类不存在时在编译期就会报错
     * 实际开发中要做到在编译期不依赖，在运行期才依赖
     */
    //controller依赖service
    private IService iService = new ServiceImpl();

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.iService.saveAccount();
    }
}
