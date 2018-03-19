package com.zhl.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zhl on 18/3/15 下午7:57.
 */

@Aspect
@Component
public class GreetingAspect {


    @Around("execution(* com.zhl.web.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        before();
        Object result = joinPoint.proceed();
        after();
        return result;
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("after");
    }

}
