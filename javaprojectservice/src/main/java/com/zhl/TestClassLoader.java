package com.zhl;

/**
 * Created by zhl on 19/1/8 下午7:57.
 */
public class TestClassLoader {


    ClassLoader classLoader = new ClassLoader() {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    };

    public static void main(String[] args) {
        ClassLoader c = TestClassLoader.class.getClassLoader();
        System.out.println(c);
        System.out.println(c.getParent());
        System.out.println(c.getParent().getParent());

    }
}
