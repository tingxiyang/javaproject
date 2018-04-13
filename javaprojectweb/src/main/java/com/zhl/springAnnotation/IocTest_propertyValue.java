package com.zhl.springAnnotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by zhl on 18/4/1 上午2:47.
 */

public class IocTest_propertyValue {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);


    @Test
    public void test01(){
//        printBeans(applicationContext);
        System.out.println("==============");
        Boolean isPerson = applicationContext.containsBean("person");
        System.out.println("是否含有person: "+ isPerson);
        Person person = (Person) applicationContext.getBean("person");
        String name = person.getNickName();
        System.out.println("name: " +name);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        System.out.println(nickName);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : definitionNames){
            System.out.println("definitionNames: "+name);
        }
    }
}
