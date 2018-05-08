package com.zhl;

import org.springframework.beans.factory.FactoryBean;

/**
 *  产品的工厂bean，返回一个产品的实例
 * Created by zhl on 18/4/25 下午6:46.
 */
public class ProductFactory implements FactoryBean<Product> {

    @Override
    public Product getObject() throws Exception {
        Product p = new Product();
        if(p.getProductId().equals("12")){
            p.setProductName("zhl");
        }
        return p;//返回的是getObject()中说明的类型，而不是创建工厂的类型，与普通的javabean不一样
    }

    @Override
    public Class<?> getObjectType() {
        return Product.class;//指定什么类型的Bean
    }

    @Override
    public boolean isSingleton() {
        return true;//true表示创建出来的对象是一个单列
    }
}
