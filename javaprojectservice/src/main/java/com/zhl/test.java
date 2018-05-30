package com.zhl;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhl on 18/3/22 下午10:13.
 */
public class test {
    public static void main(String[] args) {
       Integer resutl =  getCurrentMonthTime();
//        System.out.println(resutl);

        List<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i=0; i<10; i++){
            try{
                System.out.println(i);
                if(i == 5){
                   int s =  5/0;
                    System.out.println("s:"+s);
                }
                list.add(i);
            }catch (Exception ex){
                System.out.println("error");
//                return;
                continue;
            }

            count += 1;
            System.out.println("count:>>"+count);
        }
        System.out.println(list.toString());



    }

    public static Integer getCurrentMonthTime() {
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());
        return Long.valueOf(currentDate.plusMonths(2).withDayOfMonth(1).atStartOfDay().toEpochSecond(OffsetDateTime.now().getOffset())).intValue();
    }

}
