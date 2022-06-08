package SYS_User_manage;

import stu_system.Student;

import java.util.Scanner;

public class UserUi {
    User_Sever user_sever=new User_Sever();
    Scanner scanner=new Scanner(System.in);

    public void UserUi(String uname) {
        User[] users= user_sever.users();
        for (int i = 0; i <users.length; i++) {
            if(uname.equals(users[i].getUname())){
                System.out.println(uname+":你好  "+"   您的权限是:"+users[i].getUpower());
            }
        }
        Userui1(uname);
    }
    public void Userui1(String uname){
        System.out.println("-----------------------");
        System.out.println("1.查看个人信息 2.修改个人信息 3.回到主界面 0.退出");
        int input=scanner.nextInt();
        switch (input){
            case 1:
                select(uname);
                break;
            case 2:
                modify();
                break;
            case 3:
                Welcome_Ui welcome_ui=new Welcome_Ui();//调用其他类的方法时不可以将new对象声明升级作用域；
                welcome_ui.Welcome_menu();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("您输入有误!请重新输入");
                UserUi(uname);

        }
    }
    public void select(String uname){
        System.out.println("昵称\t密码\t邮          箱\t权限");
        User[] users= user_sever.users();
        for (int i = 0; i <users.length; i++) {
            if(uname.equals(users[i].getUname())){
                System.out.println(users[i].getUname()+"\t"+users[i].getUpassword()+"\t"
                        +users[i].getUemail()+"\t"+users[i].getUpower());
            }
        }
        Userui1(uname);
    }
    public void modify(){

    }
}
