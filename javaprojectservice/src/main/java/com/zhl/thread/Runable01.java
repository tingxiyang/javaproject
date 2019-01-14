package com.zhl.thread;

/**
 * Created by zhl on 18/12/18 下午10:43.
 */
public class Runable01 implements Runnable {
    @Override
    public void run() {
        System.out.println("zhl is a good pro");
    }

    public static void main(String[] args) {
        new Thread(new Runable01()).start();
    }

}
