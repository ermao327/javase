package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 缓冲流
 * 通过缓存提高读写的速度
 */
public class TestBufferedInputStream {
    public static void main(String[] args) {
        try(BufferedInputStream in =
                    new BufferedInputStream(new FileInputStream("aaa.txt"))){
                int len;
                StringBuilder stringBuilder = new StringBuilder();
            final byte[] bytes = new byte[8];
            while((len=in.read(bytes))!=-1){
                stringBuilder.append(new String(bytes, 0, len));
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
