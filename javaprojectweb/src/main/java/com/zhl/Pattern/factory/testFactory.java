package com.zhl.Pattern.factory;

/**
 * Created by zhl on 18/4/26 下午4:54.
 */
public class testFactory {
    public static void main(String[] args) {
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_PM);
        noodles.desc();
    }
}
