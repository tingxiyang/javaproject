package com.zhl;

import java.util.*;

/**
 * Created by zhl on 18/8/7 上午10:47.
 */
public class testTime {

    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println(day);
        long time1 = System.nanoTime();
//        Thread.sleep(500);
        long time2 = System.nanoTime();

//        System.out.println("min1: "+(time2-time1));

        long time3 = System.currentTimeMillis();
        System.out.println(time3);
        Thread.sleep(2000);
        long time4 = System.currentTimeMillis();
        System.out.println("min1: "+(time4-time3));


    }
}
