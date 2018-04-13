package com.zhl.springAnnotation;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by zhl on 18/3/22 下午8:49.
 */
public class Person {

    /**
     * 使用 @Value 赋值
     * 1. 基本数值
     * 2. 可以写SpEL;表达式 #{}
     * 3. 可以写${}; 取出配置文件中的值(在运行环境变量的值)
     */

    @Value("张宏利")
    private String name;

    @Value("#{20-1 }")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
