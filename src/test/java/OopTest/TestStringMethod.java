package OopTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestStringMethod {
    public static void main(String[] args) {
        String s = "abcdefg";
        //返回指定索引处的字符
        char c = s.charAt(3);
        System.out.println(c);

        //如果s1小于s2，则返回一个负数，如果s1大于s2,则返回一个正数,如果相等，则返回零
        //从索引0开始依次比，如果两个同位置的字符一样。则继续比，直到不一样
        String s1 = "aaa";
        String s2 = "AAA";
        int i = s1.compareTo(s2);
        System.out.println(i);
        //忽略大小写的比较
        i = s1.compareToIgnoreCase(s2);
        System.out.println(i);

        //相当于+
        String concat = s1.concat(s2);
        System.out.println(concat);

        //判断是否包含某个子字符串
        String s3 = "abcdefghijklmn";
        boolean lmn = s3.contains("lmn");
        System.out.println(lmn);

        //判断是否以某个字符串开头
        boolean abc = s3.startsWith("abc");
        System.out.println(abc);

        //是否以某个字符串结尾
        boolean lmn1 = s3.endsWith("lmn");
        System.out.println(lmn1);

        s1 = "abc";
        s2 = new String("abc");
        //切记！字符串的值的比较一定要用equals，而不是==
        boolean equals = s1.equals(s2);
        System.out.println(equals);
        //忽略大小写的比较相等
        boolean b = s1.equalsIgnoreCase(s2);

        s1 = "中华人民共和人民国";
        //编码:将字符串转成二进制的字节数组
        byte[] bytes = s1.getBytes(StandardCharsets.UTF_8);
        String s4 = new String(bytes, Charset.forName("GBK"));
        System.out.println(s4);

        //从开头查找某个字符串在该字符串中第一次出现的索引，如果没找到，则返回-1
        int index = s1.indexOf("人民2");
        System.out.println(index);

        //从某个特定的位置开始找
        index = s1.indexOf("人民",4);
        System.out.println(index);
        int last = s1.lastIndexOf("人民");
        System.out.println(last);

        String s5 = "aaa";
        String s6 = new String("aaa");
        //得到字符串的规范化表示形式
        System.out.println(s5.intern() == s6.intern());

        //叫做空字符串，长度为0的字符串
        String s7 = "";
        System.out.println(s7.isEmpty());


        //任何类型和字符串拼接，都会变成字符串
        int n = 10;
        String s8 = n + "";

        //获得字符串的长度
        System.out.println(s1.length());

        //全局替换
        String s9 = "abcwwwcdewwwxcvwww";
        String s10 = s9.replace("www", "qqq");
        System.out.println(s10);

        //分割字符串
        String s11 = "aaa@bbb@ccc@ddd";
        String[] split = s11.split("@");
        System.out.println(Arrays.toString(split));

        String s12 = "abcdefg";
        //从指定索引截断到尾部
        String substring = s12.substring(1);

        //从索引1截断到5(不包含)
        String substring1 = s12.substring(1, 5);
        System.out.println(substring1);

        //将字符串转成字符数组
        char[] chars = s12.toCharArray();
        //字符数组可以直接打印，效果就是一个字符串
        System.out.println(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        //将字符串转成大写
        String s13 = s12.toUpperCase();
        System.out.println(s13);
        //转成小写
        String s14 = s13.toLowerCase();

        //去除前后空白（ascii码的空白）
        String s15 = "      ssfwqer         ";
        String trim = s15.trim();
        System.out.println(trim.length());

        //jdk11 去除前后unicode空白
        String strip = s15.strip();

        String s16 = String.valueOf(10);
        char[] carr = new char[10];
        String s17 = String.valueOf(carr);

    }
}
