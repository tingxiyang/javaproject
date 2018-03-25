package com.zhl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhl on 18/3/23 下午6:46.
 */
public class CallableUtil {

    //线程池大小
    private Integer thread_size = 50;
    //线程池
    private ExecutorService threadPool = Executors.newFixedThreadPool(thread_size);

    //标记单线程处理基础值
    private Integer single_thread_value = 100;


    public List<String> dealWithData(List<Integer> list){
        List<String> returnList = new ArrayList<>();
        //总数量
        int dataCount = list.size();
        int totalPage = dataCount / single_thread_value;
        if(dataCount % single_thread_value != 0 ){
            totalPage = totalPage + 1;
        }

        //线程池分配资源(default 20)
        int threadSize = thread_size;
        if(totalPage < threadSize){
            threadSize = totalPage;
        }

        //分组之后的数据，平均分给每个线程，得到需要多少个线程
        int threadDataPage = totalPage / threadSize;

        //多线程处理
        CountDownLatch latch = new CountDownLatch(threadSize);
        List<Future<List<String>>> resultList = new ArrayList<>();
        for(int i = 0; i < threadSize; i++){
            int startPage = i * threadDataPage + 1;
            int endPage = (i+1) * threadDataPage;
            if(i == (threadSize - 1)){
                endPage = totalPage;
            }
            Future<List<String>> futureList = threadPool.submit(new DataCallableRunner(startPage, endPage, latch, list));
//            System.out.println("futureList:"+futureList);
            resultList.add(futureList);
        }

        try{
            latch.await();
            for(Future<List<String>> futures : resultList){
                returnList.addAll(futures.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;

    }

    //内部内
    class DataCallableRunner implements Callable<List<String>> {

        private int startPage;

        private int endPage;

        private CountDownLatch latch;

        private List<Integer> list;

        public DataCallableRunner(int startPage, int endPage, CountDownLatch latch, List<Integer> list){
            this.startPage = startPage;
            this.endPage = endPage;
            this.latch = latch;
            this.list = list;
        }

        @Override
        public List<String> call() throws Exception {
            List<String> resultList = new ArrayList<>();
            int currPage = startPage;
            try {
                for(currPage = startPage; currPage <= endPage; currPage++){
                    List<Integer> newList = new ArrayList<>();
                    //分批处理
                    if(currPage * single_thread_value > list.size()){
                        newList = list.subList((currPage - 1) * single_thread_value,
                                list.size());
                    } else {
                        newList = list.subList((currPage - 1) * single_thread_value,
                                currPage * single_thread_value);
                    }
                    try {
                        List<String> result = initData(newList);
                        resultList.addAll(result);
                    } catch (Exception ex){
                        ex.printStackTrace();
                        continue;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
            return resultList;
        }
    }

    public List<String> initData(List<Integer> list){
        List<String> result = new ArrayList<>();
        for(Integer l : list){
            if(l % 2 == 0){
                result.add("ytx:"+l);
            } else {
                result.add("zhl:"+l);
            }
        }
        return result;
    }

    public List<String> initDataNew(List<Integer> list){
        List<String> result = new ArrayList<>();
        for(Integer s : list){
            if(s % 2 == 0){
                result.add("zhl:"+s);
            } else {
                result.add("ytx:"+s);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<30000; i++){
            list.add(i+1);
        }
        System.out.println("list size():"+list.size());
        CallableUtil ca = new CallableUtil();
//        Long start = System.nanoTime();
//        List<String> result = ca.dealWithData(list);
//        System.out.println("查询总用时>>" + (System.nanoTime() - start) );
//
        Long startNew = System.nanoTime();
        List<String> resultNew = ca.initDataNew(list);
        System.out.println("查询总用时new>>" + (System.nanoTime() - startNew) );

        /*for(String r : result){
            System.out.println("name: "+r);
        }*/

    }
}
