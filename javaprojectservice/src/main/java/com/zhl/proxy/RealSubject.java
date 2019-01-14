package com.zhl.proxy;

/**
 * Created by zhl on 18/8/21 下午4:39.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("I'am realSubject");
    }
}
