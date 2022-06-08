package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 如何读完整个文件？
 */
public class TestFileInputStream3 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("aaa.txt");
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bytes = new byte[8];
            int len;//实际读的字节数，必然小于等于数组的长度
            while((len=in.read(bytes))!=-1) {
                //将字节数组的局部转成字符串
                stringBuilder.append(new String(bytes,0,len));
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
