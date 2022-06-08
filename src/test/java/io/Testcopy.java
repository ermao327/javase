package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//复制图片
public class Testcopy {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("beauty.png");
            FileOutputStream out = new FileOutputStream("beauty_copy.png")
        ){
            byte[] bytes = new byte[1024];
            int len;
            while ((len=in.read(bytes))!=-1)
            {
                out.write(bytes, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
