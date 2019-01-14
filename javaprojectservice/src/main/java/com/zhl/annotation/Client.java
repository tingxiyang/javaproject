package com.zhl.annotation;

/**
 * Created by zhl on 18/8/17 下午4:54.
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException{
        Class componentClass = Class.forName("com.zhl.annotation.UpperCaseComponent");
        if(componentClass.isAnnotationPresent(Component.class)) {
            Component component = (Component) componentClass.getAnnotation(Component.class);
            String identifier = component.identifier();
            System.out.println(String.format("Identifier for "
                    + "com.jasongj.UpperCaseComponent is ' %s '", identifier));
        } else {
            System.out.println("com.jasongj.UpperCaseComponent is not annotated by"
                    + " com.jasongj.annotation.Component");
        }

    }
}
