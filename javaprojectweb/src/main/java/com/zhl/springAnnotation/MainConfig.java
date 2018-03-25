package com.zhl.springAnnotation;

import com.zhl.springAnnotation.Person;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.zhl.springService.SpringService;

/**
 * Created by zhl on 18/3/22 下午8:58.
 */

//配置类==配置文件
/*, includeFilters = {
@Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}*/

@Configuration //告诉spring这是一个配置类
@ComponentScan(value = "com.zhl.spring*", useDefaultFilters = false,includeFilters = {
        @Filter(type= FilterType.ANNOTATION, classes = {Controller.class}),
//        @Filter(type= FilterType.ASSIGNABLE_TYPE, classes = {SpringService.class}),
        @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
})
//相当于<context:componentScan >
//FilterType.ANNOTATION 按注解指定
//FilterType.ASSIGNABLE_TYPE 按给定类型指定
//FilterType.ASPECTJ 按照ASPECTJ表达式
//FilterType.REGEX 按照正则表达式
//FilterType.CUSTOM 按照自定义指定 //需要实现TypeFilter接口


//@ComponentScan value: 指定要扫描的包，
//excludeFilters = Filter[] 指定扫描的时候按照什么规则排除哪些组件
//includeFilters = Filter[] 指定扫描的时候按照什么规则扫描哪些组件

/**
 * //@ComponentScan java8可以定义多个ComponentScan注解因为可以重复
 * java7 可以使用@ComponentScans(value={
 *@ComponentScan(value = "com.zhl", useDefaultFilters = false,includeFilters = {
@Filter(type= FilterType.ANNOTATION, classes = {Controller.class})
}),
@ComponentScan(value = "com.zhl", useDefaultFilters = false,includeFilters = {
@Filter(type= FilterType.ANNOTATION, classes = {Controller.class})
})
 *
 * })
 */

public class MainConfig {

    //给容器注册一个Bean,类型为返回值的类型，id默认是方法名作为id
    @Bean("person")       //相当于applicationContext.xml中的bean配置
    public Person person01(){
        return new Person("lisi", 20);
    }
}
