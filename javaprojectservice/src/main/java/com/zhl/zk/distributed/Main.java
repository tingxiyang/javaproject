package com.zhl.zk.distributed;

import com.zhl.zk.mysqlLock.MysqlLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhl on 18/11/28 下午4:53.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new userThread(),"user1").start();
        new Thread(new userThread(), "user2").start();
    }
    static Lock lock = new ReentrantLock();
//    static Lock lock = new MysqlLock();

    static class userThread implements Runnable {
        @Override
        public void run() {
            new Order().createOrder();
            lock.lock();
            boolean result = new Stock().reduceStaock();
            lock.unlock();
            if(result) {
                System.out.println(Thread.currentThread().getName()+"减库存成功");
                new Payment().pay();
            } else {
                System.out.println(Thread.currentThread().getName()+"减库存失败");
            }
        }
    }
}
