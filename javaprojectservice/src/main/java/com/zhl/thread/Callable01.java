package com.zhl.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by zhl on 18/12/18 下午10:48.
 */
public class Callable01 implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        String result = "zhl is a good pro";
        return result;
    }

    public static void main(String[] args) throws Exception {
        FutureTask<Object> task = new FutureTask<>(new Callable01());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
