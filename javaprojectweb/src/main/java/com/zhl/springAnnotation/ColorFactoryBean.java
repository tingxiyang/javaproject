package com.zhl.springAnnotation;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zhl on 18/3/25 下午8:52.
 */

//创建一个spring定义的bean
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        System.out.println("create colorFactoryBean....");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
