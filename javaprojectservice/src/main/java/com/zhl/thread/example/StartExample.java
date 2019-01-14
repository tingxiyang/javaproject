package com.zhl.thread.example;

/**
 * Created by zhl on 18/12/31 下午9:39.
 */
public class StartExample {

    volatile static boolean isStart = false;

    /**
     * 启动一次
     * 对象锁 和 类锁的区别
     * 加锁后，也不能解决线程安全问题，因为不一样的monitor
     *
     */
    public synchronized void start(){
        if(isStart) {
            throw new RuntimeException("服务已经启动！");
        }
        System.out.println("启动成功！");
        isStart = true;
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(() -> {
                StartExample startExample = new StartExample();
                startExample.start();
            }).start();
        }
    }
}
