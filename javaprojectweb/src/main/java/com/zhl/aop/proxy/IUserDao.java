package com.zhl.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhl on 18/4/26 下午4:17.
 */
public interface IUserDao {
    void save();
    void find();
}


class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("模拟保存用户");
    }

    @Override
    public void find() {
        System.out.println("模拟查询用户");
    }
}



/**
 * 动态代理
 *  代理工厂，给多个目标对象生成代理对象
 *
 */

class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回对目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance(){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //获取当前执行的方法的方法名
                        String methodName = method.getName();
                        //方法返回值
                        Object result = null;
                        if("find".equals(methodName)){
                            result = method.invoke(target, args);
                        } else {
                            System.out.println("开启事物。。。");
                            //执行目标对象方法
                            result = method.invoke(target, args);
                            System.out.println("提交事物");
                        }
                        return result;
                    }
                }
        );

        return proxy;
    }
}


class Main{
    public static void main(String[] args) {
        //创建目标对象
        IUserDao target = new UserDao();
        System.out.println("目标对象， "+target.getClass());

        //代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象， "+proxy.getClass());

        //执行代理对象的方法
        proxy.save();
    }
}