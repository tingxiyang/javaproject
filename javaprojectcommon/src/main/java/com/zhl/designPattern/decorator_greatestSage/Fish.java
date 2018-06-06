package com.zhl.designPattern.decorator_greatestSage;

/**
 * Created by zhl on 18/5/30 下午6:27.
 * 具体装饰角色"鱼儿"
 */
public class Fish extends Change {


    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Fish move");
    }
}
