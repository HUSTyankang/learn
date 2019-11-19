package com.spring.learn.service.impl;

import com.spring.learn.service.IService;

import java.util.Date;

public class ServiceImplSet implements IService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

       public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("账户已保存。"+name+","+age+","+birthday);
    }


}
