package com.zhl.springAnnotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by zhl on 18/3/25 下午5:48.
 */

@Component
public class Red implements ApplicationContextAware,
        BeanNameAware, EmbeddedValueResolverAware {


    private ApplicationContext applicationContext = null;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc: "+applicationContext);
        this.applicationContext = applicationContext;
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("当前beanName: "+s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好${os.name} 我是#{20*10} ");
        System.out.println("StringValueResolver解析的字符串: " + s);
    }
}
