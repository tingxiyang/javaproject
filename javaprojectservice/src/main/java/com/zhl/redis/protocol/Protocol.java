package com.zhl.redis.protocol;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhl on 18/12/24 下午7:14.
 */
public class Protocol {
    public static final String DOLLAR_BYTE = "$";
    public static final String ASTERISK_BYTE = "*";
    public static final String BLANK_BYTE = "\r\n";

    /**
     * 组装数据
     */
    public static void sendCommand(OutputStream outputStream, Command command, byte[] ... args) {
        StringBuilder sb = new StringBuilder();
        sb.append(ASTERISK_BYTE).append(args.length+1).append(BLANK_BYTE);
        sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE );
        sb.append(command.name()).append(BLANK_BYTE);
        for(final byte[] arg:args) {
            sb.append(DOLLAR_BYTE).append(arg.length).append(BLANK_BYTE);
            sb.append(new String(arg)).append(BLANK_BYTE);
        }
        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static enum Command {
        GET, SET, KEYS
    }
}
