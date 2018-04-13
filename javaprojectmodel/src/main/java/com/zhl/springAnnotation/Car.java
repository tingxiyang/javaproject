package com.zhl.springAnnotation;

import org.springframework.stereotype.Component;

/**
 * Created by zhl on 18/3/25 下午9:35.
 */
@Component
public class Car {

    private String name;

    public Car(){
        System.out.println("car construct...");
    }
    public Car(String name){
        System.out.println("car construct name...");
        this.name = name;
    }


    public void init(){
        System.out.println("car...init...");
    }


    public void destroy(){
        System.out.println("car...destroy...");
    }


}
