package com.zhl.designPattern.decorator_new;

/**
 * Created by zhl on 18/5/30 下午6:08.
 * 具体构件角色
 */
public class ConcreteComponent implements Component {
    @Override
    public void sampleOperation() {
        System.out.println("写相关业务代码");
    }
}
