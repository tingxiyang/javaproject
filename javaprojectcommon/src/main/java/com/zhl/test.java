package com.zhl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhl on 18/3/20 下午4:13.
 */
public class test {

    public static void main(String[] args) {
        //1.测试list.subList();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<100; i++){
            list.add(i);
        }
//        System.out.println(list.subList(90, 30));
        int pageSize = 30;

        //subList()
        System.out.println("++++++subList++++++");


        fenye(list, pageSize);

    }

    public static  void fenye(List list,int pagesize){

        int totalcount=list.size();
        int pagecount=0;
        int m=totalcount%pagesize;
        if  (m>0){
            pagecount=totalcount/pagesize+1;
        }else{
            pagecount=totalcount/pagesize;
        }
        System.out.println("pagecount:"+pagecount);
        for(int i=1;i<=pagecount;i++){
            if (m==0){
                List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));
                System.out.println("i"+i+":"+subList);
            }else{
                if (i==pagecount){
                    List<Integer> subList= list.subList((i-1)*pagesize,totalcount);
                    System.out.println("i"+i+":"+subList);
                }else{
                    System.out.println("i"+i);
                    List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));
                    System.out.println("i"+i+":"+subList);
                }

            }
        }

    }
}
