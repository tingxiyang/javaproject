package com.zhl.redis.con;

import com.zhl.redis.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhl on 18/12/24 下午5:23.
 */
public class Connection {

    private Socket socket;

    private String host;

    private int port;

    private OutputStream outputStream;

    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection connection() {
        try {
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 发送数据和命令
     * @return
     */
    public Connection sentCommand(Protocol.Command command, byte[] ... args) {
        connection();
        Protocol.sendCommand(outputStream, command, args );

        return this;
    }



}
