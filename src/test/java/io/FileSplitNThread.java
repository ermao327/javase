package io;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * n个线程同时将一个文件切割成n等份
 */
public class FileSplitNThread {

     public  static void main(String[] args) {
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
        int[] copied = new int[1];
        System.out.print("切割进度");
        DecimalFormat decimalFormat = new DecimalFormat("#.#%");
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = i;
            threads.add(new Thread(()->{
                try(BufferedInputStream in =
                            new BufferedInputStream(new FileInputStream(file));
                    BufferedOutputStream out =
                            new BufferedOutputStream(new FileOutputStream(
                                    file.getName()
                                            .substring(0,file.getName().lastIndexOf("."))+"_"+index+
                                            file.getName().substring(file.getName().lastIndexOf("."))));
                ){
                    final byte[] bytes = new byte[5];
                    in.skip(index*avg);
                    int rest = index == n-1 ? total-index*avg : avg;
                    int len;
                    while(rest > 0){
                        len = in.read(bytes);
                        out.write(bytes, 0, Math.min(rest, len));
                        copied[0] += Math.min(rest, len);
                        rest -= len;
                        System.out.print("=>"+decimalFormat.format(copied[0]/(double)total));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));

        }
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(file.getName()
                    .substring(0,file.getName().lastIndexOf("."))+"_copy"
                    +file.getName().substring(file.getName().lastIndexOf(".")),true));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < n; i++) {
            try(BufferedInputStream in =
                        new BufferedInputStream(new FileInputStream(file.getName()
                                .substring(0,file.getName().lastIndexOf("."))+"_"+i
                                +file.getName().substring(file.getName().lastIndexOf("."))))){
            int len;
            byte[] bytes = new byte[8];
            while((len=in.read(bytes))!=-1){
                out.write(bytes, 0, len);
                out.flush();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件下载完毕");
    }
}
