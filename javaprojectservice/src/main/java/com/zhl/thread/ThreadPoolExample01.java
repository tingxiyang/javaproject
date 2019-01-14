package com.zhl.thread;

import java.util.concurrent.*;

/**
 * Created by zhl on 18/12/19 下午9:15.
 */
public class ThreadPoolExample01 implements Runnable{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(r.getClass().getName()+"线程执行前");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("线程执行后");
            }
        };

        ThreadPoolExample01 threadPoolExample01= new ThreadPoolExample01();
        for(int i=0;i<1;i++) {
            threadPoolExecutor.execute(threadPoolExample01);
            Future future = threadPoolExecutor.submit(threadPoolExample01, 1);
            System.out.println(future.get());
        }

    }

    @Override
    public void run() {
        System.out.println("hhhhh");
    }
}
