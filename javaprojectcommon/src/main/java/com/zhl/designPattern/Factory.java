package com.zhl.designPattern;

/**
 * Created by zhl on 18/3/21 上午11:47.
 */
public class Factory {
    private Factory(){}
    public static <T> T getInstance(String className){
        T object = null;
        try {
            object = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
