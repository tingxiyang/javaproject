package com.zhl.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhl on 18/8/21 下午4:53.
 */
public class JDKDynamicpProxyTest {

    interface Subject {
        public void test1();

        public void test2();
    }

    /**
     * 实现类1
     */
    static class MySubject1  implements Subject {

        @Override
        public void test1() {
            System.out.println("MySubject1 test1 方法开始执行");

        }

        @Override
        public void test2() {
            System.out.println("MySubject1 test2 方法开始执行");

        }
    }

    static class MySubject2 implements Subject {

        @Override
        public void test1() {
            System.out.println("MySubject2 test1 方法开始执行");

        }

        @Override
        public void test2() {
            System.out.println("MySubject2 test2 方法开始执行");
        }
    }

    /**
     * 定义一个动态代理类，动态代理类必须要实现InvocationHandler接口
     */

    static class DynamicProxy implements InvocationHandler {

        private Subject target;

        //通过Proxy的newProxyInstance方法来创建我们的代理对象
        public Object getProxyObject(Subject target){
            this.target = target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

        }

        //当代理对象调用真实对象方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            method.invoke(target, args);
            System.out.println("end");
            return null;
        }
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject subject = (Subject) dynamicProxy.getProxyObject(new MySubject1());
        System.out.println("生成的代理类："+ subject.getClass());
        subject.test1();

        subject = (Subject) dynamicProxy.getProxyObject(new MySubject2());
        System.out.println("生成的代理类："+ subject.getClass());
        subject.test2();

    }

}
