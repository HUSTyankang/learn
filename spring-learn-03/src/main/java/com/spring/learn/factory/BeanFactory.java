package com.spring.learn.factory;

import com.spring.learn.dao.IDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：用java语言编写的可重用组件。
 *      javabean >  实体类
 *
 *   它就是创建我们的service和dao对象的。
 *
 *   第一个：需要一个配置文件来配置我们的service和dao
 *           配置的内容：唯一标识=全限定类名（key=value)
 *   第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *   配置文件可以是xml也可以是properties
 */

public class BeanFactory {
    private static Properties properties;
    //定义一个Map用于存放实例，把他称为容器
    private static Map<String,Object> beans;


    /**
     * 使用静态代码块为properties赋值
     * 并将反射得到的实例存放到容器中，这样就可以得到的实例是单例的
     */
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
//            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            InputStream in = ClassLoader.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()){
                //取key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射得到实例
                Object value = Class.forName(beanPath).newInstance();
                //存入容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
