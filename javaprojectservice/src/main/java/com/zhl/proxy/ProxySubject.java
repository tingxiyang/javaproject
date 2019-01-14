package com.zhl.proxy;

/**
 * Created by zhl on 18/8/21 下午4:39.
 * 静态代理
 *
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("begin");
        subject.request();
        System.out.println("end");
    }
}
