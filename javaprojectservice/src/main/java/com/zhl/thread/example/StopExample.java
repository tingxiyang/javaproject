package com.zhl.thread.example;

/**
 * Created by zhl on 18/12/30 下午9:56.
 */
public class StopExample {

    volatile boolean stop = false;

    public void shutDown (){
        stop = true;
    }

    public void doWork(){
        System.out.println("stop:"+stop);
        while (!stop) {
            //加了输出，就会打印出下面的"停机成功！"语句，因为System.out.println 有锁。
//            System.out.println("");
        }
        System.out.println("停机成功！");
    }


    public static void main(String[] args) throws InterruptedException {
        StopExample stopExample = new StopExample();
        new Thread(() -> {
            stopExample.doWork();
        }).start();


        Thread.sleep(1000);
        new Thread(() -> {
            stopExample.shutDown();
        }).start();
    }
}
