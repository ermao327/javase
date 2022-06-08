package io;

import java.io.File;
import java.util.Arrays;

/**
 * 代表文件或者路径
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("小田音乐社,傲七爷 - 枕边童话.ncm");
        //获取文件名
        final String name = file.getName();
        //获取完整的绝对路径名
        final String absolutePath = file.getAbsolutePath();
        System.out.println("简单名:"+name);
        System.out.println("绝对名字:"+absolutePath);
        //判断是否是文件
        final boolean isFile = file.isFile();
        //判断是否是文件夹（目录）
        final boolean directory = file.isDirectory();
        System.out.println(directory);

//        file.delete();//删除一个文件
//        file.getParent();文件的父级目录
//        file.length();文件的大小（字节）
//        file.exists();文件是否存在

        //文件的大小
        long length = file.length();
        System.out.println(length);

        System.out.println("------------操作文件夹------------");

        File dir = new File("D:\\IDEA\\shiyi");
        //会帮你创建所有的父子文件夹
//        dir.mkdirs();
        //如果父文件夹不存在，则创建失败
//        dir.mkdir();

        //可以得到当前路径下的所有子文件和子文件夹
        File[] subFile = dir.listFiles();
        System.out.println(Arrays.toString(subFile));
    }
}
