package com.zhl.springAnnotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by zhl on 18/3/25 下午6:30.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata 当前类的注解信心
     * @param beanDefinitionRegistry beanDefinition注入容器的注册类
     *                                  把所有添加到容器中的bean: 调用
     *                                  BeanDefinitionRegistry.registerBeanDefinition
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Boolean isRegistry = beanDefinitionRegistry.containsBeanDefinition("rainBow");

        Boolean isRed = beanDefinitionRegistry.containsBeanDefinition("com.zhl.springAnnotation.Red");

        Boolean isBlue = beanDefinitionRegistry.containsBeanDefinition("com.zhl.springAnnotation.Blue");


        if(isRed && isBlue){
            //指定bean定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);//RootBeanDefinition 是BeanDefinition父级
            //注册一个bean,指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow",  rootBeanDefinition);

        }

    }
}
