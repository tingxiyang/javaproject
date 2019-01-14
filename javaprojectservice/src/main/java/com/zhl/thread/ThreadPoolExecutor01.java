package com.zhl.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhl on 18/12/19 下午4:59.
 */
public class ThreadPoolExecutor01 implements Runnable {


    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    private static int ctlOf(int rs, int wc) { return rs | wc; }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        executorService.submit(new ThreadPoolExecutor01());
//        threadPoolExecutor.submit(new ThreadPoolExecutor01());
//        executorService.execute(new ThreadPoolExecutor01());

        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);




    }

    @Override
    public void run() {
        System.out.println("ctl:"+ctl.get());
        System.out.println("zhl is a good programmer");
    }
}
