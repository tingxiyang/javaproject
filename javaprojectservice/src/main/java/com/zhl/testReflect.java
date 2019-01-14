package com.zhl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhl on 18/7/17 下午3:17.
 */
public class testReflect {

    private static Integer commonAge = 20;

    public static void main(String[] args) {
        ParamVo vo = new ParamVo();
//        initValue(vo);
        System.out.println(vo);
        Long l = 0L;


        System.out.println(l!=0);

    }

    private static void initValue(Object obj){
        try {
            Class<?> clazz = obj.getClass();
            Method setNameMethod = clazz.getMethod("set" + initCap("name"), clazz.getDeclaredField("name").getType().getSimpleName().getClass());
            setNameMethod.invoke(obj, "张宏利");

            Field f  =clazz.getDeclaredField("age");
            f.setAccessible(true);
            f.set(obj, commonAge);

           /* Method setAgeMethod = clazz.getMethod("set" + initCap("age"), clazz.getDeclaredField("age").getType().getSimpleName().getClass());
            setAgeMethod.invoke(obj, commonAge);*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String initCap(String name){
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }
}



class ParamVo {

    private String name;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParamVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}