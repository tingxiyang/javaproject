package com.zhl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhl on 18/4/25 下午6:53.
 */
public class FactoryTest {
    public static void main(String[] args) {


    }

    @Test
    public void testFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) applicationContext.getBean("productFactory");
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
    }

}
