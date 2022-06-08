package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Simple_calendar01 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期(yyyy-MM-dd):");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int theDay = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, 1);//设置当月的1号
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(dayOfWeek);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i = 0; i < dayOfWeek-1; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
            if(theDay == i)
                System.out.print("*");
            System.out.print(i+"\t");
            calendar.set(Calendar.DATE, i);
            int dayOfWeek2 = calendar.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek2 == Calendar.SATURDAY)
                System.out.println();
        }

    }
}
