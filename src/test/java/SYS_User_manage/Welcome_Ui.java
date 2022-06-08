package SYS_User_manage;

import java.util.Scanner;

public class Welcome_Ui {
    Scanner scanner=new Scanner(System.in);
    User_Sever user_sever=new User_Sever();
    UserUi userui= new UserUi();
    public Welcome_Ui() {
        Welcome_menu();
    }
public void UserLogon(){
    System.out.println("---------用户登录界面--------");
    System.out.println("请输入用户名");
    String input1=scanner.next();
    System.out.println("请输入密码");
    String input2=scanner.next();
    boolean uname=user_sever.DecideInputUname(input1,input2);
    if(uname)
    {
        System.out.println("---------登录成功--------");
        userui.UserUi(input1);
    }
    else
    {
        System.out.println("---------请重新输入账户密码--------");
        UserLogon();
    }

}
public void UserPost(){

    }
public void AdminLogon(){

}
    public void Welcome_menu() {
        System.out.println("---------欢迎使用本系统--------");
        System.out.println("请选择:1.用户登录 2.用户注册 3.管理员登陆 0.退出");
        int input=scanner.nextInt();
        switch (input){
            case 1:
                UserLogon();
                break;
            case 2:
                UserPost();
                break;
            case 3:
                AdminLogon();
            case 0:
                System.exit(0);
            default:
                System.out.println("您输入有误!请重新输入");
                Welcome_menu();

        }
    }

    public static void main(String[] args) {
        Welcome_Ui welcome_ui = new Welcome_Ui();
    }
}
