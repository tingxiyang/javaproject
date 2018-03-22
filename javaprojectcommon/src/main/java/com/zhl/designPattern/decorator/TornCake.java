package com.zhl.designPattern.decorator;

/**
 * Created by zhl on 18/3/21 下午10:31.
 */
public class TornCake extends Pancake {

    public TornCake(){
        desc = "手抓饼";
    }
    @Override
    public double price() {
        return 4;
    }
}
