package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

//使用BufferedReader和BufferedWriter将某个文本文件里的所有的小写的a转成大写的A
//读到字符串里，字符串转数组检索，更改，对更改的后的数组out
public class FileDownToUp {
    public static void main(String[] args) {
        try(final BufferedReader in = new BufferedReader(new FileReader("aaa.txt"));
            final BufferedWriter out = new BufferedWriter(new FileWriter("aaaup"));//整个文件转大写
            final BufferedWriter out1 = new BufferedWriter(new FileWriter("aaaupchoice"))//整个文件里的a转大写
        ){
//            String s;
////            ArrayList<String> list=new ArrayList<>();//全转大写
//            while((s=in.readLine())!=null){
////                list.add(s.toUpperCase(Locale.ROOT));//全转大写
////                out.write(s.toUpperCase(Locale.ROOT));//全转大写
//            }
////            System.out.println(list);//全转大写

            String s;
            while((s=in.readLine())!=null){
                char[] chars=s.toCharArray();//字符串转字符数组
                for (int i = 0; i < chars.length; i++) {
                    if(chars[i]==97){
                        chars[i]-=32;
                    }
//                    System.out.print(chars[i]);
                }
                out1.write(chars);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
