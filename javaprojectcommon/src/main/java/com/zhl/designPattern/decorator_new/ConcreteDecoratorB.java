package com.zhl.designPattern.decorator_new;

/**
 * Created by zhl on 18/5/30 下午6:20.
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }
    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("写相关业务代码（ConcreteDecoratorB）");
    }
}
