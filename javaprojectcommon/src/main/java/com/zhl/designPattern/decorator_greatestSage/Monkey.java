package com.zhl.designPattern.decorator_greatestSage;

/**
 * Created by zhl on 18/5/30 下午6:24.
 * ConcreteComponent
 */
public class Monkey implements TheGreatestSage {

    @Override
    public void move() {
        System.out.println("Monkey Move");
    }

}
