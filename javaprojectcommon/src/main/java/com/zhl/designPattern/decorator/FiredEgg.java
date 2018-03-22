package com.zhl.designPattern.decorator;

/**
 * 煎蛋
 * Created by zhl on 18/3/21 下午10:34.
 */
public class FiredEgg extends Condiment {

    private Pancake pancake;
    public FiredEgg(Pancake pancake){
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 煎蛋";
    }

    @Override
    public double price() {
        return pancake.price()+ 2;
    }
}
