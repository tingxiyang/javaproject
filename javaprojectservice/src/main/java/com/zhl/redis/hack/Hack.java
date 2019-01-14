package com.zhl.redis.hack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhl on 18/12/24 下午5:53.
 * 模拟服务端
 */
public class Hack {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
