package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲字符输入流
 * 可以按照行来读
 */
public class TestBufferedReader {
    public static void main(String[] args) {
        try(final BufferedReader in = new BufferedReader(new FileReader("aaa.txt"))){
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            //一行一行的读
            while((s=in.readLine())!=null){
                stringBuilder.append(s).append("\n");
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
