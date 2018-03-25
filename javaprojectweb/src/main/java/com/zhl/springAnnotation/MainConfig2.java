package com.zhl.springAnnotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

/**
 * Created by zhl on 18/3/23 下午11:21.
 */

//类中组件同意设置。满足当前条件，这个类中配置的所有bean才能生效
//@Conditional({LinuxCondition.class})
@Configuration
@Import({Color.class, Red.class,
        MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class})//通过导入的方式，将color注入容器中；导入组件，id默认是组件的全名
public class MainConfig2 {
    /**
     * Scope:
     *      singleton:（default）ioc容器启动会调用方法创建对象放到ioc容器中，
     *                          以后每次获取直接从容器(map.get())中拿；
     *      prototype: ioc容器启动不会调动用法方法创建对象放在容器中，
     *                  而是每次获取时才会调用对象。
     *      web:(不常用，如果需要直接放在session域中)
     *          request:同一次请求创建一个实例
     *          session:同一个session创建一个实例
     *
     *      懒加载：
     *          单实例bean: 默认在容器启动时候创建对象
     *          懒加载： 容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化。
     *
     * @return
     */
    @Scope
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添价person...");
        return new Person("zhangsan", 22);
    }


    /**
     * @Conditional: 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是mac，给容器中注册(phone)
     * 如果系统是linux, 给容器中注册(linux)
     */
    @Conditional({MacOsCondition.class})
    @Bean("phone")
    public Person person01(){

        return new Person("乔布斯", 33);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person02(){

        return new Person("linux", 66);
    }


    /**
     * 给容器中导入组件
     * 1）: 包扫描 + 组件标注注解(@Controller/ @Service / @Repository / @Component )
     * 2) :  @Bean[导入的第三方包里面的组件]
     * 3）： @Import[快速给容器中导入一个组件]
     *         1）：@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     *         2): @ImportSelector: 返回需要导入组件的全类名
     *         3): @ImportBeanDefinitionRegistrar: 手动注册bean到容器中
     *
     * 4）：使用spring中提供的FactoryBean（工厂bean）
     *      1）： 默认获取到的是工厂bean调用getObject()创建的对象
     *      2）： 要获取工厂bean本身，getBean("&"*)， 就是需要给id前面加一个& (&colorFactoryBean)
     */
//    FactoryBean

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }











}
