package com.spring.learn.utils;

public class Logger {
    /**
     * 前置通知
     */
    public void printBeforeLog(){
        System.out.println("前置通知BeforeLog打印Log日志。。。。");
    }

    /**
     * 后置通知
     */
    public void printAfterReturningLog(){
        System.out.println("后置通知AfterReturning打印Log日志。。。。");
    }

    /**
     * 异常通知
     */
    public void printAfterThrowingLog(){
        System.out.println("异常通知AfterThrowingLog打印Log日志。。。。");
    }

    /**
     * 最终通知
     */
    public void printAfterLog(){
        System.out.println("最终通知AfterLog后置通知。。。");
    }
}
