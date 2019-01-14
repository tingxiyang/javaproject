package com.zhl.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 分布式配置中心demo
 *
 * Created by zhl on 18/8/23 下午7:36.
 */
public class ZookeeperProSync implements Watcher{

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static ZooKeeper zk = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        //zookeeper配置数据存放路径
        String path = "/username";

        //链接zookeeper并且注册一个默认的监听器  异步连接
        zk = new ZooKeeper("192.168.62.36:2181", 5000, new ZookeeperProSync());

        //等待zk连接成功的通知
        connectedSemaphore.await();

        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 实现该方法的意义：
     *
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        //zk链接成功通知事件
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (watchedEvent.getType() == EventType.NodeDataChanged) { //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为： "+new String(zk.getData(watchedEvent.getPath(), true, stat)));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
