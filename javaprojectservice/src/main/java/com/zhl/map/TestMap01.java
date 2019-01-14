package com.zhl.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhl on 18/12/19 下午11:51.
 */
public class TestMap01 {

    static final int TREEIFY_THRESHOLD = 8;


    public static void main(String[] args) {
         Map<String, String> map = new HashMap<>();
        map.put("Aa","zhl004");
        map.put("BB","zhl004");
//         map.put("张三","张三value");
//         map.put("王五","zhl003");
//         map.put("王其三","zhl003");

        TestMap01 map01 = new TestMap01();
        map01.put("张三","zhl001");
        map01.put("李四","zhl002");
        map01.put("王五","zhl003");
        map01.put("王其三","zhl003");
        map01.put("赵六","zhl004");

        map01.put("Aa","zhl004");
        map01.put("BB","zhl004");
        System.out.println("==============i==============");
        for(int i=0;;i++){
            System.out.println("i:"+i);
            if(i>=TREEIFY_THRESHOLD)
                break;
        }
        System.out.println("==============j==============");
        for(int j=0;;++j){
            System.out.println("j:"+j);
            if(j>=TREEIFY_THRESHOLD)
                break;
        }

        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");

        int a=0;
        int b=0;
        System.out.println(a++);
        System.out.println(++b);
        System.out.println("====================================================");
        Map<String, String> map1 = new HashMap<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++) {
                    map1.put(String.valueOf(i), String.valueOf(i));
                }
                System.out.println("执行完毕1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1000;i<2000;i++) {
                    map1.put(String.valueOf(i), String.valueOf(i));
                }
                System.out.println("执行完毕2");
            }
        }).start();

        try {
            Thread.currentThread().sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<2000;i++) {
            System.out.println("i:"+i+", v:"+map1.get(String.valueOf(i)));
        }





    }

    private void put(String key, String value) {
//        System.out.println(hash(key)+"："+key.hashCode());
        System.out.println(hash(key));
//        System.out.println(key.hashCode()+":"+Math.abs(key.hashCode()%15));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
