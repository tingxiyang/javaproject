package com.zhl.testAop.impl;

import com.zhl.testAop.Dao;

/**
 * Created by zhl on 18/5/3 上午11:44.
 */
public class DaoImpl implements Dao {


    @Override
    public int insert() {
        System.out.println("DaoImpl.insert()");
        return 1;
    }

    @Override
    public void delete() {
        System.out.println("DaoImpl.delete()");
    }

    @Override
    public void update() {
        System.out.println("DaoImpl.update()");
    }
}
