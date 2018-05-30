package com.zhl.Pattern.decorator;

import sun.security.provider.SHA;

/**
 * Created by zhl on 18/5/28 下午3:59.
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }


}
