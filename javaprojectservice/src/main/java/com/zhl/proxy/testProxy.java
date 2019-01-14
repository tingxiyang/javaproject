package com.zhl.proxy;

/**
 * Created by zhl on 18/8/21 下午4:41.
 */
public class testProxy {
    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.request();
    }
}
