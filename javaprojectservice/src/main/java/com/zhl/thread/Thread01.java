package com.zhl.thread;

/**
 * Created by zhl on 18/12/18 下午10:36.
 */
public class Thread01 extends Thread {
    @Override
    public void run() {
        System.out.println("zhl is a good pro");
    }

    public static void main(String[] args) {
        new Thread01().run();//方法调用 1个线程
        new Thread01().start();//线程启动 2个线程

        /**
         * run() 、 start()区别？
         * 线程数量不同
         *
         */
    }
}
