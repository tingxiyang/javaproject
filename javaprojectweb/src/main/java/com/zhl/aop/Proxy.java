package com.zhl.aop;

/**
 * 代理接口
 * Created by zhl on 18/3/16 下午3:37.
 */
public interface Proxy {

    /**
     * 执行链式代理
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
