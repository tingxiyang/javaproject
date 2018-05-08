package com.zhl.testAopService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhl on 18/5/3 下午4:10.
 */
public class LogHandler {

    private Object target;

    public LogHandler(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();

                        Object result = null;
                        if("insert".equals(methodName) || "update".equals(methodName)){
                            System.out.println(methodName +"()方法开始时间："+System.currentTimeMillis());
                            result = method.invoke(target, args);
                            System.out.println("result:"+result);
                            System.out.println(methodName +"()方法结束时间："+System.currentTimeMillis());
                        }
                        return result;
                    }
                });
        return proxy;
    }
}
