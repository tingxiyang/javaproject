package com.zhl.springAnnotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Created by zhl on 18/3/22 下午9:57.
 */
public class IocTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test04(){
        String[] beanDefinitionNames =applicationContext.getBeanDefinitionNames();
        for(String bean : beanDefinitionNames){
            System.out.println(bean);
        }

        System.out.println("begin...");
        Object bean  = applicationContext.getBean("colorFactoryBean");//获取的是color
        System.out.println("bean的类型："+ bean.getClass());

        ///加上&获取的是colorFactoryBea; 前面加上&,spring就知道拿工厂bean的本身
        Object bean2  = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean2);

    }


    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        Environment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
         String property = environment.getProperty("os.name");
        System.out.println("property: "+ property);//Mac OS X

        for(String name:names){
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }




    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] namesForType = context.getBeanNamesForType(Person.class);
       /* String[] names = context.getBeanDefinitionNames();
        for(String name : names){
            System.out.println("name: "+name);
        }*/

        Object obj1 =  context.getBean("person");
        Object obj2 =  context.getBean("person");
        System.out.println(obj1 == obj2);


    }
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        String[] namesForType = context.getBeanNamesForType(Person.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names){
            System.out.println("name: "+name);
        }
    }
}
