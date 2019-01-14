package com.zhl.thread.juc;

import sun.jvm.hotspot.ui.action.FindClassesAction;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by zhl on 19/1/7 下午3:25.
 */
public class AQStest01 {

    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 4982264981922014374L;
        Sync(int state) {
            setState(state);
        }
        int getCount(){
            return getState();
        }


    }

}
