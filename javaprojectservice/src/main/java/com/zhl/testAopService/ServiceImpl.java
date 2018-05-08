package com.zhl.testAopService;

import com.zhl.testAop.Dao;
import com.zhl.testAop.impl.DaoImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by zhl on 18/5/3 上午11:46.
 */
public class ServiceImpl {

    private Dao dao = new LogDao(new DaoImpl());//装饰器模式

    public void insert(){
//        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.insert();
//        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
    }

    public void delete(){
        dao.delete();
    }

    public void update(){
        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.update();
        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());

    }

    public static void main(String[] args) {

        Dao dao = new DaoImpl();



        Dao proxyDao = (Dao) Proxy.newProxyInstance(
                LogInvocationHandler.class.getClassLoader(),
                new Class<?>[]{Dao.class},
                new LogInvocationHandler(dao));
        proxyDao.insert();
        System.out.println("--------分割线--------");
        proxyDao.delete();
        System.out.println("--------分割线--------");
        proxyDao.update();

        System.out.println("///////////////////////////");
        LogHandler logHandler = new LogHandler(dao);
        Dao p = (Dao) logHandler.getProxyInstance();
        p.insert();
        System.out.println("========分割线=======");
        p.update();

        System.out.println("//////////////////////////");
        LogHandlerCglib logHandlerCglib = new LogHandlerCglib();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DaoImpl.class);
        enhancer.setCallback(logHandlerCglib);
        Dao dao1 = (DaoImpl)enhancer.create();
        dao1.insert();
        System.out.println("+++++++分割线+++++++");
        dao1.update();
        System.out.println("+++++++分割线+++++++");





        Animal animal = new Animal();
//        animal.getClass().getDeclaredMethod();



    }
}
