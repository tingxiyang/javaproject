package com.zhl.springAnnotation;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * bean的生命周期：
 *  bean创建---初始化---销毁
 *  容器管理bean的生命周期
 *  我们可以自定义初始化和销毁，
 *  容器在bean进行当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 *  构造(对象创建)
 *      单实例：在容器启动的时候创建
 *      多实例： 在每次获取时创建对象
 *  初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 *
 *  销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean; 容器不会调用销毁方法
 *
 *  1): 初始化和销毁方法 （基于配置时init-method、 destroy-method）
 *      指定init-method 和 destroy-method
 *  2）: 通过让Bean实现InitializingBean（定义初始化逻辑）；
 *                  disposableBean(定义销毁逻辑)
 *  3）: 可以使用JSR250;
 *          @PostConstructor(非spring): 在bean创建完成并且属性赋值完成，来执行初始化
 *          @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 *
 * Created by zhl on 18/3/25 下午9:30.
 */
/*includeFilters = {
@ComponentScan.Filter(type= FilterType.ANNOTATION,
        classes = {Component.class})}*/
@ComponentScan("com.zhl.springAnnotation")
@Configuration
public class MainConfigOfLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }


}
