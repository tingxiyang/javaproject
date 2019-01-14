package com.zhl.annotation;

import java.lang.annotation.*;

/**
 * Created by zhl on 18/8/17 下午4:50.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Component {
    String identifier () default "";
}
