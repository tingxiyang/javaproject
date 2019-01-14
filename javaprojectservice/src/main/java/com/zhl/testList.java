package com.zhl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhl on 18/7/31 下午1:21.
 */
public class testList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(19);
        list.add(19);
        list.add(19);
        list.add(20);
        list.add(22);
//        System.out.println("list: "+list);
        int initNum = list.size();
        int batchCount = initNum / 10 + (initNum%10 == 0 ? 0 : 1);
        for (int i = 0; i<batchCount; i++) {
            List<Integer> ll = list.subList(i * 10, (i+1)*10 > initNum ? initNum : (i+1)*10);
//            System.out.println(ll);
        }
//        System.out.println(list.subList(0,10));
//        System.out.println("after list: "+list);
        /*for(;;) {
            List<Integer> l = list.subList(1, 2);
            System.out.println(l);
        }*/

        Map<String, Integer> map = new HashMap<>();
//        map.merge("",1, (1) -> 1);


        List<Integer> numbers = Arrays.asList(8, 15, 12, 19);
        System.out.println(
                numbers.stream()
                        .filter(e -> e > 10)
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .map(e -> "The value is " + e)
                        .collect(toList()));

        System.out.println("====================");
        int[] factor = new int[]{2};
        Stream<Integer> stram = numbers.stream()
                .map(e -> e * factor[0]);

        factor[0] = 0;
//        stram.forEach(System.out::println);
        stram.forEach(e -> {
            System.out.println(e);
        });


        String arrayStr = "[{'key':'1', 'value':''},{'key':'2', 'value':'22'},{'key':'3', 'value':'33'},{'key':'4', 'value':'44'}]";
        List<Array> arrays = JSONArray.parseArray(arrayStr, Array.class);
        for(Array a:arrays){
            System.out.println("key:"+a.getKey());
            System.out.println("value："+a.getValue());
        }









    }
}
class Array{
    private String key;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String
    toString() {
        return "Array{" +
                "key='" + key + '\'' +
                '}';
    }
}
