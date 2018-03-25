package com.zhl.springAnnotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by zhl on 18/3/24 下午11:27.
 */
public class MacOsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否Mac系统
        /**
         * 1. 能获取到ioc使用的beanFactory（beanfactory就是创建对象以及装配的工厂）
         */
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3.获取环境
        Environment environment = conditionContext.getEnvironment();
        //4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");

        //可以判断容器中bean注册情况
        Boolean isBeanDefinition = registry.containsBeanDefinition("person");
//        registry.registerBeanDefinition("person", new Person());

        if(property.equals("Mac OS X")){
            System.out.println("是Mac操作系统");
            return true;
        }
        return false;
    }
}
