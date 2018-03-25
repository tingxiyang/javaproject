package com.zhl.springAnnotation;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Created by zhl on 18/3/22 下午11:00.
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 读取当前类正在扫描的信息
     * @param metadataReaderFactory 是一个工厂，可以探索其他类(super class and interface)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /**
         * 获取当前类注解的信息
         */
        AnnotationMetadata annotationMetadata =  metadataReader.getAnnotationMetadata();

        /**
         * 获取当前正在扫描的类的类信息
         *
         */
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        /**
         * 获取当前类资源(路径信息)
         */
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();//类名

        System.out.println("className--->: "+className);
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
