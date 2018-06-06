package com.zhl.designPattern.decorator_greatestSage;

/**
 * Created by zhl on 18/5/30 下午6:28.
 */
public class Bird extends Change {


    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Bird move");
    }
}
