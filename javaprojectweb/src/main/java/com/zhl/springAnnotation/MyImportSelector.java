package com.zhl.springAnnotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by zhl on 18/3/25 下午5:59.
 */
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {


    /**
     * 返回值，就是要导入到容器中的组件的全类名
     * @param annotationMetadata 当前标注@Import注解的类的所有信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

//        annotationMetadata
        //方法不要返回null值
        return new String[]{"com.zhl.springAnnotation.Blue"};
    }
}
