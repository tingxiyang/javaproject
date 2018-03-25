package com.zhl.thread;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhl on 18/3/24 下午4:29.
 */
public class CallableThreadTest2 {
    private static final Logger LOG = LoggerFactory.getLogger(CallableThreadTest2.class);
    public  int THROAD_SIZE = 50;
    private ExecutorService threadPool = Executors.newFixedThreadPool(THROAD_SIZE);


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<100000; i++){
            list.add(i);
        }
        CallableThreadTest2 callableThreadTest2 = new CallableThreadTest2();
        Long startNew = System.nanoTime();
        List<String> result = callableThreadTest2.handleTransactionEvents(list);
//        List<String> result = callableThreadTest2.initData(list);
        System.out.println("查询总用时new>>" + (System.nanoTime() - startNew) );

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

    /**
     * 多线程触发处理.
     *
     * @param transactionEvents 异动
     * @return 返回结果
     */
    private List<String> handleTransactionEvents(List<Integer> transactionEvents) {
        List<String> arrayList = new ArrayList<>();
//        if (transactionEvents.size() < 100) {
//            arrayList.addAll(transactionEvents);
//            return arrayList;
//        }
        //总数量
        int dataCount = transactionEvents.size();
        int totalPage = dataCount / 200;
        if (dataCount % 200 != 0) {
            totalPage = totalPage + 1;
        }
        // 线程分配资源
        int threadSize = THROAD_SIZE;
        if (totalPage < THROAD_SIZE) {
            threadSize = totalPage;
        }
        int threadDataPage = totalPage / threadSize;

        // 多线程处理
        CountDownLatch latch = new CountDownLatch(threadSize);
        List<Future<List>> futureList = new ArrayList<Future<List>>();
        for (int i = 0; i < threadSize; i++) {
            int startPage = i * threadDataPage + 1;
            int endPage = (i + 1) * threadDataPage;
            // 数据余量
            if (i == (threadSize - 1)) {
                endPage = totalPage;
            }
            Future<List> futureResult = threadPool.submit(new SelDataRunner(startPage, endPage,
                    latch, transactionEvents));
            futureList.add(futureResult);
        }
        // 等待所有线程结束
        try {
            latch.await();
        } catch (InterruptedException interruptedException) {
            LOG.error("定时触发生成分录出现异常", interruptedException);
            return arrayList;
        }
        // 线程结果确认
        boolean success = true;
        for (int i = 0; i < futureList.size(); i++) {
            try {
                Future<List> futureData = futureList.get(i);
                if (!CollectionUtils.isEmpty(futureData.get())) {
                    LOG.info("[定时触发]" + "第【" + i + "】线程执行正常！");
                } else {
                    LOG.info("[定时触发" + "]第【" + i + "】线程执行异常！");
                    success = false;
                }
                arrayList.addAll(futureData.get());
            } catch (Exception ex) {
                LOG.error("[定时触发]" + "第【" + i + "】线程执行异常！");
                success = false;
            }
        }
        if (!success) {
            LOG.info("定时触发生成分录异常！");
            return null;
        }
        return arrayList;
    }

    /**
     * 处理数据内部类.
     */
    class SelDataRunner implements Callable<List> {
        /**
         * 开始页.
         */
        private int startPage;
        /**
         * 结束页.
         */
        private int endPage;
        /**
         * 线程协调计数器.
         */
        private CountDownLatch latch;
        /**
         * 数据.
         **/
        private List<Integer> transactionEvents;

        private SelDataRunner(int startPage, int endPage,
                              CountDownLatch latch, List<Integer> transactionEvents) {
            this.startPage = startPage;
            this.endPage = endPage;
            this.latch = latch;
            this.transactionEvents = transactionEvents;
        }

        @Override
        public List call() throws Exception {
            List<String> list = new ArrayList<>();
            int currPage = startPage;
            try {
                for (currPage = startPage; currPage <= endPage; currPage++) {
                    List<Integer> newTransactionEvents = new ArrayList<>();
                    // 分批保存
                    if (currPage * 200 > transactionEvents.size()) {

                        newTransactionEvents = transactionEvents.subList((currPage - 1) * 200,
                                transactionEvents.size());
                    } else {
                        newTransactionEvents = transactionEvents.subList((currPage - 1) * 200,
                                currPage * 200);
                    }
                    try {
                        list.addAll(initData(newTransactionEvents));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        continue;
                    }
                }
                return list;
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                latch.countDown();
            }
            return list;
        }
    }
}
