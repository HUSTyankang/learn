package com.spring.learn.test;

import com.spring.learn.domain.Account;
import com.spring.learn.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */

/**
 * 1.应用程序的入口：main方法
 * 2.Junit单元测试中，没有main方法也能执行
 *         Junit集成了一个main方法
 *         该方法会判断当前测试类中哪些方法有 @Test注解
 *         junit会让有@Test注解的方法执行
 * 3.Junit不会管我们是否采用spring框架
 *         在执行测试方法时，Junit根本不知道我们是不是使用了spring框架
 *         所以也就不会为我们读取配置文件/配置类，创建spring核心容器
 * 4.由以上三点可知：当测试方法执行时，没有IOC容器，就算写了@Autowired注解，也无法实现注入
 */

/**
 * spring整合Junit
 * 1.导入Junit框架的坐标
 * 2.使用Junit提供的一个注解把原有的main方法替换，替换成spring提供的@Runwith
 * 3.告知spring的运行器，spring和ioc创建是基于xml还是基于注解的，并且说明位置，使用：@ContextConfiguration
 *      locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *      classes：指定注解所在的位置
 *
 * 当使用spring5.xxx版本的时候，需要Junit是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
//    private ApplicationContext ac;
//    private IAccountService iAccountService;
//    @Before
//    public void init(){
//        //1.获取容器
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.获取对象
//        iAccountService = ac.getBean("service",IAccountService.class);
//    }

    @Autowired
    private IAccountService iAccountService;

    @Test
    public void testFindAll() {

        List<Account> accounts = iAccountService.findAll();
        for (Account each : accounts) {
            System.out.println(each);
        }
    }

    @Test
    public void testFindById() {

        Account account = iAccountService.findById(1);
            System.out.println(account);
    }

    @Test
    public void testSaveAccount() {

        Account account = new Account();
        account.setName("yyy");
        account.setMoney(1000f);
        iAccountService.saveAccount(account);
    }

    @Test
    public void testUpdatAccount() {

        Account account = iAccountService.findById(5);
        account.setName("kkk");
        iAccountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {

        iAccountService.deleteAccount(7);
    }
}
