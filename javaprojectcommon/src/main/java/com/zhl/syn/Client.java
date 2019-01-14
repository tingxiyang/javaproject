package com.zhl.syn;

/**
 * Created by zhl on 18/6/28 下午3:44.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        boolean r = task2();
        if(r){
            task3();
        }

    }
    static boolean task2() throws InterruptedException {
        ExecutorDemo e = new ExecutorDemo();
        e.asynTask();
        System.out.println("------ task2 end ------");
        return true;
    }

    static void task3() throws InterruptedException {
        int j = 0;
        while(true){
            if(j++ > 100) {
                break;
            }
        }
        System.out.println("------ task3 end ------");
    }
}
