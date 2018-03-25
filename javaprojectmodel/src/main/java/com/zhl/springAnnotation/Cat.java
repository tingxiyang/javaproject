package com.zhl.springAnnotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by zhl on 18/3/25 下午10:25.
 */
@Component
public class Cat implements InitializingBean, DisposableBean {


    public Cat(){
        System.out.println("cat constructor...");
    }

    /**
     * 对象实例化之后调用此方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("cat...afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }
}
