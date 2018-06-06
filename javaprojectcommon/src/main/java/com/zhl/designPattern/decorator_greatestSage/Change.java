package com.zhl.designPattern.decorator_greatestSage;

/**
 * Created by zhl on 18/5/30 下午6:25.
 * 抽象装饰角色"七十二变"
 */
public class Change implements TheGreatestSage {

    private TheGreatestSage sage;

    public Change(TheGreatestSage sage){
        this.sage = sage;
    }

    @Override
    public void move() {
        //code
        System.out.println("代码");
        sage.move();
    }
}
