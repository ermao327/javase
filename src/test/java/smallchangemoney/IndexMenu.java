package smallchangemoney;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class IndexMenu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        int input=0;
        double money=0;
        double balance=0;
        String project=" ";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        Date date=null;
        String details = "\n------------------零钱通明细-------------------";
        do{
            System.out.println("--------零钱通---------");
            System.out.println("\t1 零钱通明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费");
            System.out.println("\t4 退出");
            System.out.print("请选择(1-4)");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    //万事万物碰到判断的先找出不正确的条件，直接break，直到正确；
                    //千万不要先判断正确的，千万养成先判断错误的习惯；
                    System.out.println("收益入账金额");
                    money=scanner.nextDouble();

                    if(money<=0)
                    {
                        System.out.println("金额需要大于0");
                        break;
                    }
                    balance+=money;
                    date=new Date();
                    details+="\n"+"收益入账"+"\t+"+money+"\t"+df.format(date)+"\t"+balance;
                    break;
                case 3:
                    System.out.println("消费项目");
                    project=scanner.next();
                    System.out.println("消费金额");
                    money=scanner.nextDouble();
                    if(money<0)
                    {
                        System.out.println("你买东西不会有商家给你钱吧");
                        break;
                    }
                    if(money>balance)
                    {
                        System.out.println("兄弟，钱不够了");
                        break;
                    }
                    balance-=money;
                    date=new Date();
                    details+="\n"+project+"\t-"+money+"\t"+df.format(date)+"\t"+balance;
                    break;
                case 4:
                    String choice=" ";
                    while (true)
                    {
                        System.out.println("确定退出嘛y/n");
                        choice=scanner.next();
                        if("y".equals(choice)||"n".equals(choice))
                        {
                            break;
                        }
                    }
                    if(choice.equals("y"))
                    {
                        loop=false;
                    }
                    break;
                default:
                    System.out.println("选择错误，请重新输入");
            }
        }
        while (loop);
        System.out.println("退出系统.........");
    }
}
