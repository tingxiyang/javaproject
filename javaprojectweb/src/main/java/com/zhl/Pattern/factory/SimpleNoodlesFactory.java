package com.zhl.Pattern.factory;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by zhl on 18/4/26 下午4:52.
 */
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_GK = 3;//干扣面

    public static INoodles createNoodles(int type){
        switch (type){
            case TYPE_LZ:
                return new LzNodles();
            case TYPE_PM:
                return new PaoNodles();
            case TYPE_GK:
                return new GankouNoodles();
            default:
                return new GankouNoodles();
        }
    }
}
