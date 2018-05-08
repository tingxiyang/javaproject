package com.zhl.testAopService;

import com.zhl.testAop.Dao;

/**
 * Created by zhl on 18/5/3 上午11:53.
 *
 * 装饰器模式
 */
public class LogDao implements Dao {

    private Dao dao;

    public LogDao(Dao dao){
        this.dao = dao;
    }


    @Override
    public int insert() {
        System.out.println("insert(1)方法开始时间：" +
                System.currentTimeMillis());
        dao.insert();
        System.out.println("insert(2)方法结束时间：" +
                System.currentTimeMillis());
        return 1;
    }

    @Override
    public void delete() {
        dao.delete();
    }

    @Override
    public void update() {
        System.out.println("update()方法开始时间：" +
                System.currentTimeMillis());
        dao.update();
        System.out.println("update()方法结束时间：" +
                System.currentTimeMillis());
    }
}
