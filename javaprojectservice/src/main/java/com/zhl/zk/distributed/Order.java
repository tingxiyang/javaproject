package com.zhl.zk.distributed;

/**
 * Created by zhl on 18/11/28 下午4:52.
 */
public class Order {

    public void createOrder(){
        System.out.println(Thread.currentThread().getName()+"创建订单");
    }
}
