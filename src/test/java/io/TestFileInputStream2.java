package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 如何读完整个文件？
 */
public class TestFileInputStream2 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("aaa.txt");
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bytes = new byte[8];
            //会造成字节冗余
            while(true) {
                int read = in.read(bytes);
                if(read == -1)
                    break;
                stringBuilder.append(new String(bytes));
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
