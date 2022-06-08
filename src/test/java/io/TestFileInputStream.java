package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 如何读完整个文件？
 */
public class TestFileInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("aaa.txt");
//            StringBuilder stringBuilder = new StringBuilder();
//            while(true) {
//                int read = in.read();
//                if(read == -1)
//                    break;
//                stringBuilder.append((char) read);
//            }
//            System.out.println(stringBuilder);
//            in.skip(3);//跳过多少个字节
//            in.mark(100);
//            in.reset();
            System.out.println((char)in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
