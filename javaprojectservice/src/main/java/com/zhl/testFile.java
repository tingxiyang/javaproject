package com.zhl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by zhl on 18/7/11 下午2:11.
 */
public class testFile {
    public static void main(String[] args) {
        int SIZE = 4096;

        try {
//            OutputStream os = new FileOutputStream("/tmp/sss.txt");
            FileInputStream fis = new FileInputStream("/tmp/sss.txt");
            int len = 0;
            byte[] buf = new byte[SIZE];
            while((len=fis.read(buf))!=-1){
                System.out.println(new String(buf,0,len));
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

