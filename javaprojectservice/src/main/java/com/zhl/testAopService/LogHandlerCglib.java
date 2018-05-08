package com.zhl.testAopService;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhl on 18/5/3 下午4:22.
 * 使用cglib
 */
public class LogHandlerCglib implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if("insert".equals(methodName) || "update".equals(methodName)){
            System.out.println(methodName +"(cglib)方法开始时间："+System.currentTimeMillis());
            Object obj = methodProxy.invokeSuper(o, objects);
            System.out.println("obj:>"+obj);
            System.out.println(methodName +"(cglib)方法结束时间："+System.currentTimeMillis());
            return obj;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
