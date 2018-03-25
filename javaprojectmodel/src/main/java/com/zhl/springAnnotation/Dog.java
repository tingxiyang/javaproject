package com.zhl.springAnnotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by zhl on 18/3/25 下午10:55.
 */
@Component
public class Dog {

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
}
