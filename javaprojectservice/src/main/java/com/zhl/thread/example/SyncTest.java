package com.zhl.thread.example;

/**
 * Created by zhl on 19/1/2 上午9:49.
 */
public class SyncTest {
    public void syncBlock(){
        synchronized (this) {
            System.out.println("hello block");
        }
    }

    public synchronized void syncMethod(){
        System.out.println("hello method");
    }
}
