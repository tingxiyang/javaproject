package com.zhl.aop;


import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理链
 * Created by zhl on 18/3/16 下午3:38.
 */

public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;


    private List<Proxy> proxyList = new ArrayList<>();

    private int proxyIndex  = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod,
                      MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList){
            this.targetClass = targetClass;
            this.targetMethod = targetMethod;
            this.targetObject = targetObject;
            this.methodParams = methodParams;
            this.methodProxy = methodProxy;
            this.proxyList = proxyList;
    }

    public Object[] getMethodParams(){

        return methodParams;
    }

    public Class<?> getTargetClass() {

        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object doProxyChain() throws Throwable {
        Object methodResult;
        if(proxyIndex < proxyList.size()){
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetClass, methodParams);
        }
        return methodResult;
    }
}
