package io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符输入流
 */
public class TestFileReader {
    public static void main(String[] args) {
        try(FileReader in = new FileReader("aaa.txt")){
            char[] chars = new char[10];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while((len=in.read(chars))!=-1){
                stringBuilder.append(chars,0,len);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
