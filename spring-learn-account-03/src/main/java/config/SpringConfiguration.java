package config;

import org.springframework.context.annotation.*;


/**
 * 该类是一个配置类，它的作用和bean.xml的作用是一样的。
 * Spring中的新注解
 * @Configuration：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigurationContext对象创建的参数时，该注解可以不写。
 * @ComponentScan：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：value和basePackages的作用是一样的，都是用于指定创建容器要扫描的包。
 *      使用此注解就等同于早xml中配置了：<context:component-scan base-package="com.spring.learn"></context:component-scan>
 * @Bean:用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：name用于指定bean的id，没写时bean的id时函数的名称。
 *      细节：当我使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的。
 * @Import：用于导入其他的配置类
 *      属性：value用于指定其他配置类的字节码。
 *          当我们使用Import的注解之后，有Import注解的类就是主配置类，而导入的都是子配置类。
 * @PropertySource:用于指定properties文件的位置
 *      属性：value指定文件的名称和路径
 *          关键字：classpath，表示类路径下
 */
//@Configuration
@ComponentScan(basePackages = "com.spring.learn")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
