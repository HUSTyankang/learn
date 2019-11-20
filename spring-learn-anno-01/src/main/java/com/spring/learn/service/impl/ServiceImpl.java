package com.spring.learn.service.impl;

import com.spring.learn.dao.IDao;
import com.spring.learn.dao.impl.DaoImpl;
import com.spring.learn.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * 曾经的XML的配置：
 *  <bean id="service" class="com.spring.learn.service.impl.ServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref=""></property>
 *   </bean>
 *
 *  用于创建对象的
 *      他们的作用就和在XML配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      @Component:
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id。当没有写时，它的默认值是当前类名，且首字母改小写。
 *      @Controller：一般用在表现层
 *      @Service：一般用在业务层
 *      @Repository：一般用在持久层
 *      上面的三个注解的作用和属性与Component是一模一样的。
 *      他们三个是spring框架为我们提供的明确的三层使用的注解，使我们的三层对象更加清晰。
 *  用于注入数据的
 *      他们的作用就和在XML配置文件中的<bean></bean>标签编写一个<property></property>标签的作用是一样的
 *      @Autowired:自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。（理解按类型注入：就是申明的变量是什么类型的）
 *              如果ioc容器中有多个类型匹配时：按照类型圈定匹配的范围，再根据变量名在该范围中进行匹配，没匹配成功则报错。
 *          出现位置：可以是变量上，也可以是方法上。
 *          细节：在使用注解注入时，set方法就不是必须的了。
 *      @Qualifier:在按照类注入的基础之上再按照名称注入。它在给成员注入时不能单独使用。但是在给方法参数注入时可以
 *          属性：value用于指定注入bean的id。
 *      @Resource:直接按照bean的id注入。它可以独立使用
 *          属性：name用于指定bean的id。
 *      以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过XML来实现。
 *
 *      @Value：用于注入基本类型和String类型的数据
 *          属性：value用于指定数据的值，它可以使用spring中的SpELl表达式（spring中的el表达式）
 *              SpEL表达式的写法：${表达式}
 *  用于改变作用范围的
 *      他们的作用就和在<bean></bean>标签中使用scope属性实现的功能是一样的
 *      @Scope：用于指定bean的作用范围
 *          属性：value指定范围的取值。常用值：singleton prototype
 *  和生命周期相关的
 *      他们的作用就和在<bean></bean>标签中使用init-method和destroy-method的作用是一样的
 *      @PreDestroy:用于指定销毁方法
 *      @PostConstruct:用于指定初始化方法
 */
//@Component("service")
@Service("service")
//@Scope(value = "prototype")
//@Scope(value = "singleton")
public class ServiceImpl implements IService {
//    @Autowired
//    @Qualifier("dao2")
    @Resource(name = "dao2")
    private IDao dao;

    public ServiceImpl(){
        System.out.println("对象已创建。。。");
    }

    @PostConstruct
    public void init(){
        System.out.println("对象初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("对象销毁");
    }

    public void saveAccount() {
        dao.saveAccount();
    }

}
