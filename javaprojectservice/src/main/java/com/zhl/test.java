package com.zhl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhl on 18/3/22 下午10:13.
 */
public class test {
    public static void main(String[] args) throws Exception {
        /*Integer resutl =  getCurrentMonthTime();
//        System.out.println(resutl);
       List<Integer> list = new ArrayList<>();
        int count = 0;
        System.out.println("test java >>> and >> and ^");
        System.out.println(120574 >>> 16);
        System.out.println(85 >>> 3);*/

//        testForeachRemove();
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.getTime()/1000);


        List<Integer> list = new ArrayList<>();
        list.add(60);
        list.add(31);
        list.add(31);
        list.add(90);
        list.add(18);
        list.add(23);
        list.add(99);
        list.add(99);
        list.add(76);
        list.add(190);
        list.add(5);
        list.add(5);
        System.out.println(list);
        List<Integer> list1 = list.stream().sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println(list1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Date> dateList = new ArrayList<>();
        String s1 = "2018-05-03 00:00:00";
        String s5 = "2018-06-1 00:00:00";
        String s2 = "2018-05-03 00:00:00";
        String s3 = "2018-05-02 00:00:00";
        String s4 = "2018-05-04 00:00:00";
        Date d1 = sdf.parse(s1);
        Date d2 = sdf.parse(s2);
        Date d3 = sdf.parse(s3);
        Date d4 = sdf.parse(s4);
        Date d5 = sdf.parse(s5);
        dateList.add(d1);
        dateList.add(d2);
        dateList.add(d3);
        dateList.add(d4);
        dateList.add(d5);
        System.out.println(dateList);

        List<Date> dateList1 = dateList.stream().distinct().sorted().collect(toList());

        System.out.println(dateList1);


    }

    private static void testForeachRemove(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println("before list:"+list);
        for(String item:list){
            if("2".equals(item)){
                list.remove(item);
            }
        }
        System.out.println("after list:"+list);
    }



    public static final int hash(Object key) {
        int h;
        System.out.println("hashCode:"+key.hashCode());
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static Integer getCurrentMonthTime() {
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());
        return Long.valueOf(currentDate.plusMonths(2).withDayOfMonth(1).atStartOfDay().toEpochSecond(OffsetDateTime.now().getOffset())).intValue();
    }

}
