package SysAtm;

import SYS_User_manage.User;
import SYS_User_manage.Welcome_Ui;

import java.util.Scanner;

public class CustomerUi {
    Scanner scanner=new Scanner(System.in);
    BankSystemSever bankSystemSever=new BankSystemSever();
    Customer[] customers=bankSystemSever.customers();
    AtmSysteam[] atmSysteams=bankSystemSever.atmSysteams();

    public void CustomerUi(String cid){
        for (int i = 0; i <customers.length; i++) {
            if(cid.equals(customers[i].getCardid())){
                System.out.println(customers[i].getUname()+":你好");
            }
        }
        CustomerUi1(cid);
    }
    public void CustomerUi1(String cid){
        System.out.println("----------用户操作界面-------------");
        System.out.println("1.查询 2.存款 3.取款 4.返回登录界面 5.转账 0.返回操作界面");
        int input=scanner.nextInt();
        switch (input){
            case 1:
                select(cid);
                break;
            case 2:
                SaveMoney(cid);
                break;
            case 3:
                 DrawMoney(cid);
                break;
            case 4:
                BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
                bankSystemUi.Welcome_menu();
                break;
            case 5:
                transfermoney(cid);
                break;
            case 0:
                CustomerUi1(cid);
                break;
            default:
                System.out.println("您输入有误!请重新输入");
                CustomerUi1(cid);

        }
    }
    public void transfermoney(String cid){
        System.out.println("请输入转账方账户");
        String input1=scanner.next();
        System.out.println("请输入转账方姓名");
        String input2=scanner.next();
        int itname=bankSystemSever.Transfer(input1,input2);
        if(itname==1)
        {   System.out.println("请输入转账金额");
            int input3=scanner.nextInt();
            int num= bankSystemSever.CheckTransferMoney(input3);
            if(num==1)
            {
                for (int i = 0; i <customers.length; i++) {
                    if(cid.equals(customers[i].getCardid())){
                        customers[i].setMoney(customers[i].getMoney()-input3);
                    }
                    if(input1.equals(customers[i].getCardid())){
                        customers[i].setMoney(customers[i].getMoney()+input3);
                    }
                }
                System.out.println("---------转账成功--------");
                System.out.println("是否需要打印凭条:1.需要 0.返回登录界面");
                int input=scanner.nextInt();
                if(input==1)
                {
                    System.out.println("南京新街口华夏银行ATM自动存取款机");
                    System.out.println("您此次的操作：转账"+input3+"元");
                    System.out.println("感谢您对华夏银行的支持");
                    CustomerUi1(cid);
                }
                else
                {
                    BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
                    bankSystemUi.Welcome_menu();
                }
            }
            else if(num==9876)
            {
                System.out.println("您的余额不足");
                CustomerUi1(cid);
            }
            else if(num==9877)
            {
                System.out.println("不能输入5000以上的数字");
                BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
                bankSystemUi.Welcome_menu();
            }
            else if(num==9666)
            {
                System.out.println("金额不能小于100，请重新输入");
                BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
                bankSystemUi.Welcome_menu();
            }

        }
        else if(itname==2)
        {
            System.out.println("---------请校对对方账号--------");
        }
        else if(itname==3)
        {
            System.out.println("---------请校对对方姓名--------");
        }
        else if(itname==-99999)
        {
            System.out.println("---------不支持跨行转账--------");
        }
    }
    public void select(String cid){
        System.out.println("姓名\t身份证号\t卡号\t\t余额\t\t开卡时间\t\t账户状态");
        for (int i = 0; i <customers.length; i++) {
            if(cid.equals(customers[i].getCardid())){
                System.out.println(customers[i].getUname()+"\t"+customers[i].getId()+"\t\t"
                        +customers[i].getCardid()+"\t"+customers[i].getMoney()+"\t"+customers[i].getLondate()
                        +"\t"+customers[i].getStatus());
            }
        }
//        System.out.println(":1.需要 0.退卡");
        CustomerUi1(cid);
    }
    public void SaveMoney(String cid){
        System.out.println("请输入存款金额");
        String savemoney1 = scanner.next();
        int savemoney=Integer.parseInt(savemoney1);
        int num=bankSystemSever.SaveMoney(savemoney);
        if(num==1)
        {
            for (int i = 0; i <customers.length; i++) {
                if(cid.equals(customers[i].getCardid())){
                    customers[i].setMoney(customers[i].getMoney()+savemoney);
                    atmSysteams[0].setAtmmoeny(atmSysteams[0].getAtmmoeny()+savemoney);
                }
            }
        }
        else if(num==0)
        {
            System.out.println("只支持交易金额为100的倍数");
            BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
            bankSystemUi.Welcome_menu();
        }

        System.out.println("是否需要打印凭条:1.需要 0.返回登录界面");
        int input=scanner.nextInt();
        if(input==1)
        {
            System.out.println("南京新街口华夏银行ATM自动存取款机");
            System.out.println("您此次的操作：存款"+savemoney+"元");
            System.out.println("感谢您对华夏银行的支持");
            CustomerUi1(cid);
        }
        else
        {
            BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
            bankSystemUi.Welcome_menu();
        }
    }
    public void DrawMoney(String cid){
        System.out.println("请输入取款金额");
        String drawmoney1 = scanner.next();
        int drawmoney=Integer.parseInt(drawmoney1);
        int num=bankSystemSever.DrawMoney(drawmoney);
        if(num==1){
            for (int i = 0; i <customers.length; i++) {
                if(cid.equals(customers[i].getCardid())){
                    customers[i].setMoney(customers[i].getMoney()-drawmoney);
                    atmSysteams[0].setAtmmoeny(atmSysteams[0].getAtmmoeny()-drawmoney);
                }
            }
            System.out.println("是否需要打印凭条:1.需要 0.返回登录界面");
            int input=scanner.nextInt();
            if(input==1)
            {
                System.out.println("南京新街口华夏银行ATM自动存取款机");
                System.out.println("您此次的操作：取款"+drawmoney+"元");
                System.out.println("感谢您对华夏银行的支持");
                CustomerUi1(cid);
            }
            else
            {
                BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
                bankSystemUi.Welcome_menu();
            }
        }
        else if(num==9876)
        {
            System.out.println("您的余额不足");
            CustomerUi1(cid);
        }
        else if(num==9877)
        {
            System.out.println("不能输入5000以上的数字");
            BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
            bankSystemUi.Welcome_menu();
        }
        else if(num==9899)
        {
            System.out.println("该ATM机现金不足，请更换一台取款");
            BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
            bankSystemUi.Welcome_menu();
        }
        else if(num==9666)
        {
            System.out.println("金额不能小于100，请重新输入");
            BankSystemUi bankSystemUi=new BankSystemUi();//调用其他类的方法时不可以将new对象声明升级作用域；
            bankSystemUi.Welcome_menu();
        }


    }


}
