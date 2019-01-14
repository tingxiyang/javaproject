package com.zhl.redis.client;

import com.zhl.redis.con.Connection;
import com.zhl.redis.protocol.Protocol;

/**
 * Created by zhl on 18/12/24 下午5:39.
 *
 * api操作层
 *
 */
public class Client {

    Connection connection;

    public Client(String host, int port) {
        this.connection = new Connection(host, port);
    }

    public String set(String key, String value) {
        //todo
        connection.sentCommand(Protocol.Command.SET,key.getBytes(), value.getBytes());

        return null;
    }

    public String get(String key) {

        return null;
    }


}
