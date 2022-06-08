package io;

import java.io.File;

public class PrintFiles {

//打印一个文件夹得所有目录
    public static void printFileNames(File file,int level){
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        if(file.isFile()){
            System.out.println("-"+file.getName());
        }
        else{
            System.out.println("*"+file.getName());
            level++;
            //子文件夹
            File[] files = file.listFiles();
            for (File subFile : files) {
                printFileNames(subFile,level);
            }
        }
    }

    public static void main(String[] args) {
        printFileNames(new File("D:\\IDEA\\shiyi"),0);
    }
}

