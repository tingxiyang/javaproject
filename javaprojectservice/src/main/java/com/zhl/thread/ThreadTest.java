package com.zhl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhl on 18/12/18 下午11:55.
 * 不用线程池
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();
        for (int i=0; i<10000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("时间: "+(System.currentTimeMillis() - start));
        System.out.println("size: "+list.size());
        /**
         * 时间: 1194
         * size: 10000
         */
    }
}
