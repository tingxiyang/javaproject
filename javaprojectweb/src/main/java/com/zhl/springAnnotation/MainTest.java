package com.zhl.springAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhl on 18/3/22 下午8:50.
 */
public class MainTest {
    public static void main(String[] args)   {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person: "+person);*/

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) context.getBean("person");
        System.out.println("person: "+person);

        String[] namesForType = context.getBeanNamesForType(Person.class);
        for(String name : namesForType){
            System.out.println("name: "+name);
        }
    }
}
