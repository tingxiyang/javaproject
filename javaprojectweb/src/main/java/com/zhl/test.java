package com.zhl;

import org.springframework.util.Assert;

/**
 * Created by zhl on 18/3/15 下午7:46.
 */
public class test {
    public static void main(String[] args) {
        String s = transformedBeanName("&beanfactory");
        System.out.println(s);//beanfactory
    }
    public static String transformedBeanName(String name) {
        String beanName;
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
            ;
        }
        return beanName;
    }
}
