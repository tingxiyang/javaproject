package com.zhl.java8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by zhl on 18/8/23 下午3:28.
 */
public class testLoop {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i < 5;i++){
            int temp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running task "+temp);
                }
            });
        }
//        executorService.shutdown();

        System.out.println("--------------------------------");

        IntStream.rangeClosed(0, 5) //equals <=
//        IntStream.range(0, 5)
                .forEach(i -> executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Running task "+i);
                    }
                }));
        executorService.shutdown();
    }
}
