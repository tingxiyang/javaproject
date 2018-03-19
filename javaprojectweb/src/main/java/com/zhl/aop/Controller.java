package com.zhl.aop;

import org.aspectj.lang.annotation.Aspect;

/**
 * Created by zhl on 18/3/16 下午5:07.
 */

@org.springframework.stereotype.Controller
public class Controller {
    public void test(){
        System.out.println("hello, world");
    }
}
