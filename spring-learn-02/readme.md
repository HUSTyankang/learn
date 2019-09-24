# 使用工厂模式解耦
## Bean
在计算机英语中，有可重用组件的含义。  

## javaBean
用java语言编写的可重用组件。javaBean >  实体类。    
程序中的JavaBean是创建的service和dao对象。  
* **第一**：需要一个配置文件来配置我们的service和dao配置的内容：唯一标识=全限定类名（key=value)；
* **第二**：通过读取配置文件中配置的内容，反射创建对象。    
    
配置文件可以是xml也可以是properties。   

## 程序
class是获取当前类的class对象；    
getClassLoader()是获取当前的类加载器；
* **类加载器**：用来加载java类，类加载器就是负责把class文件加载进内存中，并创建一个java.lang.Class类的一个实例，也就是class对象,并且每个类的类加载器都不相同

getResourceAsStream(path)是用来获取资源的；  
因为这是ClassLoader了获取资源，而类加载器默认是从classPath下获取资源的，因为这下面有class文件。所以这段代码总的意思是通过类加载器在classPath目录下获取资源。并且是以流的形式。  
使用Class.forName( )静态方法的目的是为了动态加载类；
在加载完成后，一般还要调用Class下的newInstance( )静态方法来实例化对象以便操作。单单使用Class.forName( )是动态加载类是没有用的，其最终目的是为了实例化对象。 
Class下的newInstance()和new的区别：    
* 首先，newInstance( )是一个方法，而new是一个关键字；    
* 其次，Class下的newInstance()的使用有局限，因为它生成对象只能调用无参的构造函数，而使用 new关键字生成对象没有这个限制。

Class.forName("")返回的是类；  
Class.forName("").newInstance()返回的是对象。