package com.zhl.springAnnotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 要是需要一个ioc容器，实现ApplicationContextAware就可以
 *
 * Created by zhl on 18/3/25 下午10:55.
 */
@Component
public class Dog implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    public Dog(){
        System.out.println("Dog...constructor...");
    }


    //对象创建并复制之后
    @PostConstruct
    public void init(){
        System.out.println("Dog...PostConstruct...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog...PreDestroy...");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
