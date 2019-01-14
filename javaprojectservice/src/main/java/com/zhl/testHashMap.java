package com.zhl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhl on 18/8/15 下午5:06.
 */
public class testHashMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("zhl", "123123");
//        System.out.println(map.get("zhl"));
        String key = "zhl";
//        int h = key.hashCode();
        int h = 2;
        int r = h ^ (h >>> 16);
        System.out.println(h);
        System.out.println(r);

        System.out.println("begin");
        for(int index = 0;; ++index){
            System.out.println(index);
            if(index == 89){
                System.out.println("index"+index);
                break;
            }
        }
        System.out.println("end");

    }
}
