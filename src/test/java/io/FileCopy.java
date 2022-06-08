package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("beauty.png");
            FileOutputStream out = new FileOutputStream("beauty_copy.png")
        ){
            byte[] bytes = new byte[8];
            int len;//实际读的字节数，必然小于等于数组的长度
            while((len=in.read(bytes))!=-1) {
                //将字节数组的局部写道文件里，不会造成字节的冗余
                out.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
