package com.zhl.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhl on 18/6/28 下午3:40.
 */
public class ExecutorDemo {
    private ExecutorService executor = Executors.newFixedThreadPool(1);

    public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    //方便观察结果
                    Thread.sleep(10000);
                    for(int i=0; i<10000;i++){
                        for(int j=10000; j >= 0; j--){
                            if(i == j){
                                System.out.println("i: "+i +" j: "+j);
                            }
                        }
                    }



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int sum = 0;
                for(int i = 0;i < 1000; i++){
                    sum += i;
                }
                System.out.println("sum: "+sum);
            }
        });
    }
}
