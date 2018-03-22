package com.zhl.designPattern.decorator;

/**
 * Created by zhl on 18/3/21 下午10:29.
 */
public abstract class Pancake {
    public String desc = "我不是一个具体的煎饼，我只是一个饼";

    public String getDesc() {
        return desc;
    }
    public abstract double price();
}
