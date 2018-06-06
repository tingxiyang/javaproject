package com.zhl.designPattern.decorator_new;

/**
 * Created by zhl on 18/5/30 下午6:09.
 * 装饰角色
 */
public class Decorator implements Component {
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void sampleOperation() {
        System.out.println("委派给构件");
        component.sampleOperation();
    }
}
