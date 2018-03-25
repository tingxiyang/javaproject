package com.zhl.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by zhl on 18/3/24 下午4:20.
 */
public class CallableThreadTest implements Callable<Integer> {

    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                new Thread(ft,"又反回的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值："+ft.get());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"- "+i);
        }
        return i;
    }
}
