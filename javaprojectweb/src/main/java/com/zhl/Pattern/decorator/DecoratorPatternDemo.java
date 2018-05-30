package com.zhl.Pattern.decorator;

import sun.security.provider.SHA;

/**
 * Created by zhl on 18/5/28 下午4:04.
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");

        circle.draw();

        System.out.println("\nCircle of border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
