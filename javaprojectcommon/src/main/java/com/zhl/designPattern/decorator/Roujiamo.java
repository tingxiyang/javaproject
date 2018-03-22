package com.zhl.designPattern.decorator;

/**
 * Created by zhl on 18/3/21 下午10:32.
 */
public class Roujiamo extends Pancake {

    public Roujiamo(){
        desc = "肉夹馍";
    }

    @Override
    public double price() {
        return 6;
    }
}
