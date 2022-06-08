package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ioTest01 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("aaa.txt");
            StringBuilder stringBuilder=new StringBuilder();
//            while (true){
//                int read = in.read();
//                System.out.print((char) read);
//                if(read==-1)
//                {
//                    break;
//                }
//            }

            byte[] bytes=new byte[8];
            int len;
            while ((len=in.read(bytes))!=-1)
            {
                stringBuilder.append(new String(bytes,0,len));
            }
            System.out.println(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
