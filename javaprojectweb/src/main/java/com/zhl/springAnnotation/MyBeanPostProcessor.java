package com.zhl.springAnnotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by zhl on 18/3/26 下午10:18.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization name->"+s
                +" bean->"+o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization name->"+s
                +" bean->"+o);
        return o;
    }
}
