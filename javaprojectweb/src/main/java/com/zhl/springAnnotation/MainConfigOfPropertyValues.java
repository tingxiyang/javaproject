package com.zhl.springAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zhl on 18/4/1 上午2:43.
 */

//@ComponentScan("com.zhl.springAnnotation")
@Configuration
//加载外部配置文件，使用propertySource读取外部配置文件中的k/v然后保存到运行的环境中
@PropertySource({"classpath:system.properties"})
public class MainConfigOfPropertyValues {


    @Bean
    public Person person(){
        return new Person();
    }


}
