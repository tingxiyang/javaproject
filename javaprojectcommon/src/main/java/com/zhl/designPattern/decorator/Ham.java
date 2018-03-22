package com.zhl.designPattern.decorator;

/**
 * Created by zhl on 18/3/21 下午10:37.
 */
public class Ham extends Condiment {

    private Pancake pancake;

    public Ham(Pancake pancake){
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 火腿肠";
    }

    @Override
    public double price() {
        return pancake.price() + 1.5;
    }
}
