package com.zhl.zk.mysqlLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by zhl on 18/11/28 下午5:09.
 */
public class MysqlLock implements Lock {

    private static String LOCK_NAME = "mysqlLock";

    //
    @Override
    public void lock() {
        while(true) {
            if(tryLock()) {
                //insert
                return;
            } else {
                //阻塞锁
                System.out.println("waiting...");
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //查询
        int count = 0;
        if(count ==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //delete

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
