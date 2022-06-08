package OopTest;

import java.util.Arrays;

public class StringText {
    public static void main(String[] args) {
//        打印字符串”sadewrdsfs"中第8个字符;
       /* String s="sadewrdsfs";
        System.out.println(s.substring(7,8));*/

    /*    System.out.println("sadewrdsfs".charAt(7));*/

//        判断字符串”java@oracle.com”中是否包含字符”@“;
/*        String s="java@oracle.com";
        String arr[]=s.split("@");
        int a=Arrays.toString(arr).length();
        if(a!=s.length())
            System.out.println("包含字符”@“");*/

    /*    System.out.println("java@oracle.com".contains("@"));*/

//        将字符串“[java@oracle.com](mailto:java@oracle.com)“中”@”与”.“之间的字符串截取出来；
      /*  String s="[java@oracle.com](mailto:java@oracle.com)";
        String arr[]=s.split("@|\\.");
        System.out.println(Arrays.toString(arr));*/

/*        String s = "java@oracle.com";
        System.out.println(s.substring(
                s.indexOf("@")+1,s.indexOf(".")
        ));*/

//        计算字符串" I love Java  "首尾共有多少个空白字符；
/*        String s=" I love Java  ";
        String s1=s.strip();
        int a=s.length()-s1.length();
        System.out.println("首尾共有"+a+"个空白字符");*/


//        将字符串“aAbBcCdDeE“中所有的小写字符转成大写字符，大写字符转成小写字符，生成一个新的字符串；
        //方法一
/*        String s="aAbBcCdDeE";
        char[] arr =s.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>='a'&&arr[i]<='z')
//            if(65-(int)arr[i]<0)//为什么转换之后各别是错的？？？
                arr[i]-= 32;
            else
                arr[i]+= 32;
        }
        System.out.println(arr);*/

        //方法二
/*        String s="aAbBcCdDeE";
        for(int i=0;i<s.length();i++)
        {
           if(Character.isLowerCase(s.charAt(i)))
               System.out.print((s.charAt(i)+"").toUpperCase());
           else
               System.out.print((s.charAt(i)+"").toLowerCase());
        }*/

//        将字符串“abcdefg”倒序生成一个新的字符串；
/*        String s = "abcdefg";
        char [] s1 = s.toCharArray();
        for (int i = 0; i <s1.length/2; i++) {
            char temp=s1[i];
            s1[i]=s1[s1.length-i-1];
            s1[s1.length-i-1]=temp;
        }
        System.out.println(s1);
        System.out.println(String.valueOf(s1));*/

/*        StringBuilder sb = new StringBuilder("abcdefg");
        String s = sb.reverse().toString();*/


//        统计字符串“abcdefgabdcdefgabcddefg”里有多少个字符‘d’；
/*        String s="abcdefgabdcdefgabcddefg";
        char [] s1= s.toCharArray();
        int count=0;
        for (char c : s1) {
            if (c == 'd')
                count++;
        }
//        for (int i = 0; i < s1.length; i++) {
//            if(s1[i]=='d')
//                count++;
//        }
        System.out.println(count);*/


//        计算字符串“11#2#333#444#55“中各个数字之和，即”11+2+333+…”;
/*        String s="11#2#333#444#55";
        String[] s1=s.split("#");
//        int [] s2 = new int[s1.length];
        int sum=0;
        for (int i = 0; i <s1.length; i++) {
            sum+= Integer.parseInt(s1[i]);
//            sum+=s2[i];
        }
        System.out.println(sum);*/


    }
}
