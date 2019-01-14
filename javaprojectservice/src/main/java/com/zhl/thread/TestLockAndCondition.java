package com.zhl.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhl on 18/12/10 下午5:53.
 */
public class TestLockAndCondition {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread thread1 = new Thread((Runnable) () -> {
            try {
                reentrantLock.lock();
                System.out.println("我要等一个新信号");
                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我拿到一个信号！！！");
            reentrantLock.unlock();

        });
        thread1.start();


        Thread thread2 = new Thread((Runnable) () -> {
            try {
                reentrantLock.lock();
                System.out.println("我拿到锁了");
                Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("我发了一个信号！！！");
            reentrantLock.unlock();
        });
        thread2.start();


    }


}
