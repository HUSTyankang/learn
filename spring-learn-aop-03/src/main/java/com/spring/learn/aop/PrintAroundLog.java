package com.spring.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class PrintAroundLog {
    /**
     * 分析:
     *     通过对比动态代理的环绕通知代码,发现动态代理的环绕通知有明确的切入点方法调用.而我们的没有
     * 解决:
     *     Spring框架为我们提供了一个接口,proceedingJoinPoint.该接口有一个方法proceed()此方法就相当于明确调用切入点方法.
     *     该接口可以作为环绕通知的方法参数,在程序执行时,Spring框架会为我们提供该接口的实现类供我们使用
     * Spring中的环绕通知:
     *     它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    public Object printAroundLog(ProceedingJoinPoint pjp){
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("前置通知BefLog打印日志。。。前置");
            returnValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
            System.out.println("后置通知AfterReturningLog打印日志。。。后置");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("异常通知AfterThrowingLog打印日志。。。异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("最终通知AfterLog打印日志。。。最终");
        }
    }
}
