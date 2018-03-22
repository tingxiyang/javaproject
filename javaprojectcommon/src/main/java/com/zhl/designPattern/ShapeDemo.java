package com.zhl.designPattern;

import sun.security.provider.SHA;

/**
 *
 * 工厂模式有三种： 简单工厂模式，抽象工厂模式和工厂方法模式
 * Created by zhl on 18/3/21 上午11:24.
 */

//一、简单工厂模式
//以图形为列
interface Shape{
    public void draw();
}

//图形
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle is drawing");
    }
}

//矩形
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle is drawing");
    }
}

//图形工厂
class ShapeFactory {
    public static <T> T createShape(String name) throws Exception {
        return (T) Class.forName(name).newInstance();//利用反射机制来产生对象
    }
}


public class ShapeDemo {
    public static void draw(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) throws Exception {
//        draw(ShapeFactory.createShape("com.zhl.designPattern.Circle"));
//        draw(ShapeFactory.createShape("com.zhl.designPattern.Rectangle"));
          Shape shape = Factory.getInstance("com.zhl.designPattern.Circle");
          shape.draw();//Circle is drawing
    }
}
