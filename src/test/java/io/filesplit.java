package io;

import java.io.*;
import java.util.zip.InflaterInputStream;
//将一个文件切割成2等份，对半切
public class filesplit {
    public static void main(String[] args) {
        try(BufferedInputStream in1 = new BufferedInputStream(new FileInputStream("aaa.txt"));
            final BufferedInputStream in2 = new BufferedInputStream(new FileInputStream("aaa.txt"));
            final BufferedOutputStream out1 = new  BufferedOutputStream(new FileOutputStream("aaa1.txt"));
            final BufferedOutputStream out2 = new  BufferedOutputStream(new FileOutputStream("aaa2.txt"))

        ) {
            final File aaa = new File("aaa.txt");
            final byte[] bytes = new byte[5];
            int half=(int) aaa.length()/2;
            int rest=half;
            int len;
            while (rest>0)
            {
                len= in1.read(bytes);
                out1.write(bytes,0,Math.min(rest, len));
                rest-=len;

            }

            in2.skip(half);
            while ((len=in2.read(bytes))!=-1){
                out2.write(bytes,0,len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
