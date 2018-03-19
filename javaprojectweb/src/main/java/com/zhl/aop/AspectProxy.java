package com.zhl.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面代理
 * Created by zhl on 18/3/16 下午3:56.
 */
public class AspectProxy implements Proxy{
    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        try {
            if(intercet(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure {}",e);
            error(cls, method, params, e);
            throw e;
        } finally {
            end();
        }
        return result;
    }

    public void begin(){}

    public boolean intercet(Class<?> cls, Method method, Object[] params) throws Throwable{
        return true;
    }
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {

    }
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {

    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable error){

    }
    public void end(){

    }
}
