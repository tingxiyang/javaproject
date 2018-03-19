package com.zhl.web;

import org.springframework.stereotype.Component;

/**
 * Created by zhl on 18/3/15 下午11:15.
 */
@Component
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, "+ name);
    }
}
