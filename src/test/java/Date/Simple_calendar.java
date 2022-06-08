package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Simple_calendar {
    public static void main(String[] args) throws ParseException {
        int firstDay;
        int maxDay;
        int currentDay;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期：例如：yyyy-MM-dd");
        String s = sc.nextLine();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = s1.parse(s);//        将字符串转换为日期格式
//        Calendar c = new GregorianCalendar();
        Calendar c=Calendar.getInstance();
        c.setTime(d);//        将日期格式转换为日历
        maxDay =c.getActualMaximum(Calendar.DATE);//获取一个月中有多少天
        currentDay = c.get(Calendar.DATE); //键盘录入的那一天
        c.set(Calendar.DATE,1);// 这个月的第一天
        firstDay = c.get(Calendar.DAY_OF_WEEK);//获取第一天是星期几
        System.out.println("------------------------------------");
        System.out.println("周日\t周一\t周二\t周三\t周四\t周五\t周六\n");
        for (int i = 1;i < firstDay;i++) {
            System.out.print("\t");
        }
        for (int j = 1;j <=maxDay;j++) {
            if (j == currentDay) {
                System.out.print(j+"*"+"\t");//*表示键盘录入的那天
            }else {
                System.out.print(j+"\t");
            }
            if ((j-(8-firstDay))%7 ==0) {//以七天为一个循环，在跳转到下一行进行输出
                System.out.print("\n");
            }
        }
        System.out.println("");
        System.out.println("------------------------------------");
    }
}
