package com.zhl.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by zhl on 18/12/24 下午5:12.
 */
public class testJedis {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.30.68", 6379);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(14);
        jedis.set("zhl","very good");
        System.out.println(jedis.get("zhl"));

    }
}