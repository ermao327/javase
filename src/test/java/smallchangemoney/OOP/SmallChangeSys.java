package smallchangemoney.OOP;

import com.sun.jdi.request.BreakpointRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//完成方法
public class SmallChangeSys {
    Scanner scanner=new Scanner(System.in);
    boolean loop=true;
    int input=0;
    double money=0;
    double balance=0;
    String project=" ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
    Date date=null;
    String details = "\n------------------零钱通明细-------------------";
    public void mainmenu(){
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
                   detail();
                    break;
                case 2:
                    income();
                    break;
                case 3:
                   pay();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("选择错误，请重新输入");
            }
        }
        while (loop);
        System.out.println("退出系统.........");
    }
    //显示明细
    public  void detail(){
        System.out.println(details);
    }
    //入账
    public  void income(){
        System.out.println("收益入账金额");
        money=scanner.nextDouble();

        if(money<=0)
        {
            System.out.println("金额需要大于0");
//            income();
            return;//退出方法,不往下执行
        }
        balance+=money;
        date=new Date();
        details+="\n"+"收益入账"+"\t+"+money+"\t"+df.format(date)+"\t"+balance;
    }
    //消费
    public  void  pay(){
        System.out.println("消费项目");
        project=scanner.next();
        System.out.println("消费金额");
        money=scanner.nextDouble();
        if(money<0)
        {
            System.out.println("你买东西不会有商家给你钱吧");
            return;
        }
        if(money>balance)
        {
            System.out.println("兄弟，钱不够了");
            return;
        }
        balance-=money;
        date=new Date();
        details+="\n"+project+"\t-"+money+"\t"+df.format(date)+"\t"+balance;
    }
    //退出
    public void exit(){
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
    }


}
