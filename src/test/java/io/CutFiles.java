package io;

import java.io.*;
import java.util.Scanner;

/**
 * 将一个文件切割成n等份
 *可以切割音频，切割音频图片，切割音频文件
 */
public class CutFiles {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要分割的文件路径：");
//        String filePath = scanner.next();
        File srcFile = new File("D:\\IDEA\\shiyi\\小田音乐社,傲七爷 - 枕边童话.ncm");
        System.out.println("请输入要分割的份数：");
        int n = scanner.nextInt();

        long pointer = 0;
        // 分成 n 段，每段的长度，加 1 为防止数据丢失
        long parentLength = srcFile.length() / n + 1;
        RandomAccessFile rafSrc = new RandomAccessFile(srcFile, "r");
        for (int i = 1; i < n + 1; i++) {
            // 分割的子文件的名字
            RandomAccessFile rafDec = new RandomAccessFile(new File(
                    srcFile.getParent(), "part" + i + "."
                    + srcFile.getName().split("\\.")[1]), "rw");

            // 将文件指针 指向上次分割完成时的指针位置
            rafSrc.seek(pointer);

            byte[] buffer = new byte[(int) parentLength];
            int len = rafSrc.read(buffer);
            rafDec.write(buffer, 0, len);
            pointer = rafSrc.getFilePointer();

        }
    }
}
