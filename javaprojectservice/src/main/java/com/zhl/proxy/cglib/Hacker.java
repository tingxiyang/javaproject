package com.zhl.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhl on 18/8/22 上午10:24.
 * 实现了方法拦截器接口
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("*** I am a hacker, Let's see what the poor programmer is doing now...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("*** Oh, what a poor programmer...");
        return null;
    }
}
