package io;

import java.io.*;

public class filesplitN {
    public static void main(String[] args) {
        int n = 5;
        File file = new File("aaa.txt");
        split(file, n);
    }

    public static void split(File file,int n){
        if(n > file.length() / 2){
            throw new IllegalArgumentException("n不可以超过文件总长度的一半，当前的n是"+n);
        }
        int total = (int)file.length();
        int avg = total / n;
        int [] copied=new int[1];
        System.out.println("进度");

        for (int i = 0; i < n; i++) {
            int index=i;
            new Thread(()->{
                try(BufferedInputStream in =
                            new BufferedInputStream(new FileInputStream(file));
                    BufferedOutputStream out =
                            new BufferedOutputStream(new FileOutputStream("aaa_"+index+".txt"));
                ){
                    final byte[] bytes = new byte[5];
                    in.skip(index*avg);
                    int rest = index == n-1 ? total-index*avg : avg;
                    int len;
                    while(rest > 0){
                        len = in.read(bytes);
                        out.write(bytes, 0, Math.min(rest, len));
                        rest -= len;
                        copied[0]+=Math.min(rest, len);
                        System.out.println("=>"+copied[0]/total);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ).start();

        }

    }
}
