package com.zhl.zk.distributed;

/**
 * Created by zhl on 18/11/28 下午4:53.
 */
public class Payment {
    public void pay(){
        System.out.println(Thread.currentThread().getName()+"支付成功");
    }
}
