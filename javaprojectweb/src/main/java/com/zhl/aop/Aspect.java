package com.zhl.aop;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by zhl on 18/3/16 下午3:35.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
