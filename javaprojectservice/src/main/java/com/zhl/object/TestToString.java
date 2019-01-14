package com.zhl.object;


import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhl on 18/8/30 上午11:09.
 */
public class TestToString {

    public  static final byte INSURANCE_LIST_TYPE_ADD = 1;
    public static final byte WORK_ORDER_TYPE_TRANSFER = 2;
    public  static final byte INSURANCE_LIST_TYPE_DEL = 2;


    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1);
        order.setCode("JD321");
        order.setName("北京航空");
        System.out.println(order);

        Byte b = 1;
        if(b.equals(1)){

        }


        List<Integer> l1 = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4)).flatMap(m -> m.stream()).collect(toList());
        List<String> l3 = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4)).map(m -> m.toString()).collect(toList());
        System.out.println(l3);


        Integer i1 = 100000;
        Integer i2 = 90000;
        if(i1 >= i2){
            System.out.println("是是是");
        }

        String code = "FW2018001";
        String codeStr = code.substring(code.length()-3);
        System.out.println(codeStr);
        String codestr1 = "010";
        System.out.println(Integer.parseInt(codestr1));
        Integer num = Integer.parseInt(codeStr);
        num = num + 1;

        DecimalFormat df = new DecimalFormat("000");
        int n = 20;
        System.out.println(df.format(n));

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("downloadKey", "hsssh");
        resMap.put("attachmentId", 1);
        String json = JSONObject.toJSONString(resMap);
        System.out.println(json);

        boolean f = validate("FW118001");
        System.out.println("f: "+f);
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        System.out.println("year: "+year);


        String testLength = "张宏利zhldwwfew112";
        System.out.println("length:"+testLength.trim().length());


        Byte businessType = 1;
        Byte type2 = 1;
        if(((Byte)INSURANCE_LIST_TYPE_ADD).equals(businessType )){
            Byte type = type2 == null ? (Byte) WORK_ORDER_TYPE_TRANSFER : type2;
            System.out.println("oooooooo");
            System.out.println(type);
        } else if (((Byte)INSURANCE_LIST_TYPE_DEL).equals(businessType)) {
            System.out.println("sssssss");
        }






    }

    private static  boolean validate(String code) {
        boolean flag = false;
        //中文校验
        String regChinese = "[\u4e00-\u9fa5]";
        Pattern p1 = Pattern.compile(regChinese);
        Matcher m1 = p1.matcher(code);
        if(m1.find()){
//            return false;
        }

        //只能包含数字，字母，下划线
        String regEx =  "[\\w]";
        Pattern p2 = Pattern.compile(regEx);
        Matcher m2 = p2.matcher(code);
        if(!m2.matches()){
//            return false;
        }
        //第一位不能是数字或下划线
//        String regFirst = "/^[a-zA-Z]\\w{2,19}$/";
//        String regFirst = "/^[a-zA-Z0-9_]*$/";
//        String regFirst = "^[A-Za-z][A-Za-z1-9_-]";
        String regFirst = "^[a-zA-z][a-zA-Z0-9_]+$";

        Pattern p3 = Pattern.compile(regFirst);
        Matcher m3 = p3.matcher(code);
        boolean reg3 = m3.matches();
        System.out.println("reg3: "+reg3);

        return flag;
    }
}

class Order {
    private Integer id;

    private String code;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
