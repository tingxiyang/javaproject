package com.zhl.zk.distributed;

/**
 * Created by zhl on 18/11/28 下午4:51.
 */
public class Stock {

    private static Integer count = 1;

    public boolean reduceStaock(){
        System.out.println("count:"+count);
        if (count>0){
            count--;
            return true;
        }
        return false;
    }

}
