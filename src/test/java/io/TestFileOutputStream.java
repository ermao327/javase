package io;

import java.io.FileOutputStream;
import java.io.IOException;

//IO流一定要用完立即关闭
public class TestFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("bbb.txt",true);
            out.write("abcdefg".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
