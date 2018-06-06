package com.zhl.designPattern.decorator_greatestSage;

/**
 * Created by zhl on 18/5/30 下午6:29.
 */
public class Client {

    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();

//        TheGreatestSage bird = new Bird(sage);

        sage = new Fish(sage);

        sage.move();

    }
}
