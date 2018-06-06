package com.zhl.designPattern.decorator_new;

/**
 * Created by zhl on 18/5/30 下午6:14.
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("写相关业务代码（ConcreteDecoratorA）");
    }
}
