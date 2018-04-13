package com.zhl.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zhl on 18/4/1 下午6:36.
 */
public class SpringApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    public SpringApplicationContextUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }


}
