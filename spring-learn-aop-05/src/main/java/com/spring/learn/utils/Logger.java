package com.spring.learn.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* com.spring.learn.service.impl.*.*(..))")
    public void ptl(){}
    /**
     * 在使用除环绕通知的其他通知时，他们的顺序并不是一定的，
     * 最终通知会执行优先于后置通知与环绕通知,因此当我们使用
     * 最终通知来释放一些资源的时候，可能会出现资源已经释放，
     * 但是后置通知仍在使用的情况，这时就会出现错误，因此我
     * 们遇到这种情况时要特别注意，为了保证通知的顺序，我们
     * 必要的使用环绕通知，环绕通知的执行顺序是一致的。
     *
     */

//
//    /**
//     * 前置通知
//     */
//    @Before("ptl()")
//    public void printBeforeLog(){
//        System.out.println("前置通知BeforeLog打印Log日志。。。。");
//    }
//
//    /**
//     * 后置通知
//     */
//    @AfterReturning("ptl()")
//    public void printAfterReturningLog(){
//        System.out.println("后置通知AfterReturning打印Log日志。。。。");
//    }
//
//    /**
//     * 异常通知
//     */
//    @AfterThrowing("ptl()")
//    public void printAfterThrowingLog(){
//        System.out.println("异常通知AfterThrowingLog打印Log日志。。。。");
//    }
//
//    /**
//     * 最终通知
//     */
//    @After("ptl()")
//    public void printAfterLog(){
//        System.out.println("最终通知AfterLog后置通知。。。");
//    }

    /**
     * 分析:
     *     通过对比动态代理的环绕通知代码,发现动态代理的环绕通知有明确的切入点方法调用.而我们的没有
     * 解决:
     *     Spring框架为我们提供了一个接口,proceedingJoinPoint.该接口有一个方法proceed()此方法就相当于明确调用切入点方法.
     *     该接口可以作为环绕通知的方法参数,在程序执行时,Spring框架会为我们提供该接口的实现类供我们使用
     * Spring中的环绕通知:
     *     它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("ptl()")
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
