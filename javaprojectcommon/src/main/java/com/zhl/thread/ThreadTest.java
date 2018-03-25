package com.zhl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhl on 18/3/24 下午5:00.
 */
public class ThreadTest {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

        List<String> strList = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            strList.add("String" + i);
        }

        int threadNum = strList.size() < 10 ? strList.size() : 10;
        Long startNew = System.nanoTime();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
//                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < threadNum; i++) {
            threadPool.execute(new PrintStringThread(i, strList, threadNum));
        }
        System.out.println("查询总用时++++++++++++++=======new>>" + (System.nanoTime() - startNew) );

        threadPool.shutdown();
    }



}

    class PrintStringThread implements Runnable {

        private int num;

        private List<String> strList;

        private int threadNum;

        public PrintStringThread(int num, List<String> strList, int threadNum) {
            this.num = num;
            this.strList = strList;
            this.threadNum = threadNum;
        }

        public void run() {
            int length = 0;
            for(String str : strList){
                if (length % threadNum == num) {
                    System.out.println("线程编号：" + num + "，字符串：" + str);
                }
                length ++;
            }
        }
    }
