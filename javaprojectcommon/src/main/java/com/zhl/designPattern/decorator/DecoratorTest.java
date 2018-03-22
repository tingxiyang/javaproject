package com.zhl.designPattern.decorator;

/**
 * Created by zhl on 18/3/21 下午10:40.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Pancake tornCake = new TornCake();
        tornCake = new Ham(tornCake);//火腿肠
        //手抓饼基础价
        System.out.println(String.format("%s ￥%s", tornCake.getDesc(), tornCake.price()));

        Pancake roujiamo = new Roujiamo();

        roujiamo = new FiredEgg(roujiamo);
        roujiamo = new Ham(roujiamo);
        System.out.println(String.format("%s ￥%s", roujiamo.getDesc(), roujiamo.price()));
    }
}
