package OopTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Text01 {

    public static void main(String[] args) {
        //依次打印字符串每个字符的ascii码
/*        String s="aasdasdasd";
        for (int i = 0; i <s.length(); i++) {
            System.out.print((int)s.charAt(i)+"\t");
        }*/

/*        String s="aasdasdasd";
        char [] chars=s.toCharArray();
        for(char achar:chars)
        {
            System.out.print((int)achar+"\t");
        }*/


/*        String s = "张三,李四,王五,王柳,李六,王琦,张义,王一";
        String[] arr = s.split(",");
        System.out.println(Arrays.toString(arr));
        int count=0;
       for(String name:arr)
       {
           if(name.startsWith("张"))
               count++;
           else if(name.startsWith("王"))
               count--;
       }
       if(count>0)
           System.out.println("老王多");
        else if(count<0)
            System.out.println("老张多");
        else
           System.out.println("海霞");*/


//        字符串首字母大写,其他小写
/*        String s="i am Ja Wsdsd  ASDAD";
        String[] arr = s.split(" ");
        List<String> tmp = new ArrayList<String>();
        for(String str:arr){  //循环数据
            if(str!=null && str.length()!=0){  //把不为空与空格的字符串存放到list里
                tmp.add(str);
            }
        }
        arr = tmp.toArray(new String[0]);
        for(int i=0;i<arr.length;i++)
        {
            String first.txt = arr[i].substring(0,1).toUpperCase();
            String next = arr[i].substring(1);
            String last=first.txt+next;
            System.out.println(last);
        }*/

        //字符串反转
/*        String s="i am Ja Wsdsd ASDAD";
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length/2; i++) {
            char temp=chars[i];
            chars[i]=chars[chars.length-i-1];
            chars[chars.length-i-1]=temp;
        }
        System.out.println(String.valueOf(chars));*/


    }


}
