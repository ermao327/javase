package SysAtm;

import SYS_User_manage.User_Sever;
import stu_system.Student;

import javax.swing.text.html.CSS;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class BankSystemUi {
    Scanner scanner=new Scanner(System.in);
    BankSystemSever bankSystemSever=new BankSystemSever();
    CustomerUi customerUi=new CustomerUi();
    Customer[] customers=bankSystemSever.customers();
    AtmSysteam[] atmSysteams=bankSystemSever.atmSysteams();
    BankSystem[] bankSystems=bankSystemSever.bankSystems();
    int countcid=1;
    String input3="1";

    public BankSystemUi() {
        BankSystemUi();
    }

    public void BankSystemUi() {
        System.out.println("---------欢迎使用南京新街口华夏银行ATM自动存取款机--------");
        System.out.println("1.用户登录 0.管理员登录");
        int input=scanner.nextInt();
        if(input==1)
        {
            Welcome_menu();
        }
        else if(input==0)
        {
            adminlogin();
        }

    }
    public void adminlogin(){
        System.out.println("请输入管理员账号");
        String input1=scanner.next();
        System.out.println("请输入管理员密码");
        String input2=scanner.next();
        int uname=bankSystemSever.DecideInputadmin(input1, input2);
        if(uname==1)
        {
            System.out.println("---------登录成功--------");
            AdminMenu();
        }
        else if(uname==9110)
        {
            System.out.println("---------密码是6位数,憨憨！--------");
            BankSystemUi();
        }
        else if(uname==2)
        {
            System.out.println("---------账号错误--------");
            BankSystemUi();
        }
        else if(uname==4)
        {
            System.out.println("---------全都错--------");
            BankSystemUi();
        }

        else if(uname==3){
            if(countcid!=3)
            {
                countcid++;
                adminlogin();
            }
            else if(countcid==3){
                for (int i = 0; i <bankSystems.length; i++) {
                    if (input1.equals(bankSystems[i].getUname())) {
                        bankSystems[i].setUpassword(input2);
                    }
                }
                System.out.println("---------找你上司去吧，等着离职吧--------");
                BankSystemUi();//能实现效果，但有点小bug
            }
        }
    }
    public void AdminMenu(){
        System.out.println("请选择:1.注册新用户 2.解冻用户密码 3.注销账户 4.查询账户 5.返回主菜单 0.退出系统");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                addnewuser();
                break;
            case 2:
                modifypwd();
                break;
            case 3:
                logoffacc();
                break;
            case 4:
                adminselect();
                break;
            case 5:
                BankSystemUi();
                break;
            case 0:
                System.out.println("系统退出,再见.................");
                System.exit(0);
                break;
            default:
                BankSystemUi();
        }
    }
    public void logoffacc(){
        System.out.println("请输入要注销的卡号:");
        String cid = scanner.next();
        boolean b = bankSystemSever.deleteById(cid);
        if(b){
            System.out.println("注销成功");
            AdminMenu();
        }
        else{
            System.out.println("注销失败！请选择:1.重新输入 2.返回菜单 0.退出系统");
            boolean flag = true;
            while(true) {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        flag = false;
                        logoffacc();
                        break;
                    case 2:
                        flag = false;
                        AdminMenu();
                        break;
                    case 0:
                        System.out.println("正在退出.....");
                        System.exit(0);//JVM停掉了
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
            }
        }
    }
    public void addnewuser(){
        //姓名，密码，身份证号输入并校验；姓名3位，密码6位，身份证号3位;
        // 注册日期自动生成；注册当天;
        // 余额默认为0；,如需要存款，在注册成功之后进行存款;
        // 卡号随机生成5位数字；并且随机的号码不在数据库内存在;
        System.out.println("----请输入新用户的信息-----");
        System.out.println("请输入姓名:");
        String Nname = scanner.next();
        System.out.println("请输入密码:");
        String Npwd = scanner.next();
        System.out.println("请输入身份证号:");
        String Nid = scanner.next();
        double d=Math.random();
        int k=(int)(10000+d*(99999-10000+1));//随机五位数
        String Ncid=String.valueOf(k);
//        String Nstauts="1";

        int num=bankSystemSever.CheckNewAcc(Nname, Npwd, Ncid, Ncid);
        if(num==888)
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String Nlondate= df.format(new Date());//日期转字符串
            Customer customer=new Customer(Nname,Npwd,Ncid,Nlondate,Nid,0,"1");
            bankSystemSever.addOne(customer);
            System.out.println("注册成功");
            System.out.println("您的卡号:"+Ncid);
            AdminMenu();
        }
        else if(num==9187)
        {
            System.out.println("名字长度为3，请重新输入");
            addnewuser();
        }
        else if(num==9110)
        {
            System.out.println("密码为长度为6的数字，请重新输入");
            addnewuser();
        }
        else if(num==-9878)//做随机卡号的验证，如果和库里的卡号相同就再次随机；有点暴力，直接重新输入注册信息；
        {
            addnewuser();
        }



    }
    public void modifypwd(){
        System.out.println("请输入需要解冻的用户卡号");
        String input=scanner.next();
        boolean num = bankSystemSever.decideInputId(input);
        if(num){
            for (int i = 0; i <customers.length; i++) {
                if(input.equals(customers[i].getCardid())){
                    customers[i].setStatus("1");
                    System.out.println("解冻成功:");
                }
            }
            AdminMenu();

        }
        else
        {
                System.out.println("你要解冻的账户不存在，请选择:1.重新输入 2.返回菜单 0.退出系统");
                int input1=scanner.nextInt();
                switch (input1)
                {
                    case 1:
                        modifypwd();
                        break;
                    case 2:
                        AdminMenu();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
        }
    }

    public void adminselect(){
        Customer[] customers=bankSystemSever.selectAll();
        System.out.println("姓名\t身份证号\t卡号\t\t余额\t\t开卡时间\t\t账户状态");
        for (Customer customer : customers) {
            System.out.println(customer.getUname()+"\t"+customer.getId()+"\t\t"
                    +customer.getCardid()+"\t"+customer.getMoney()+"\t"+customer.getLondate()
                    +"\t"+customer.getStatus());
        }
        AdminMenu();
    }
    public void Welcome_menu() {
        System.out.println("请输入卡号");
        String input1 = scanner.next();
        System.out.println("请输入密码");
        String input2 = scanner.next();
        boolean uname = bankSystemSever.DecideInputCardid(input1, input2, input3);
        for (Customer value : customers) {
            if (value.getStatus().equals(input3)&&uname) {
                    System.out.println("---------登录成功--------");
                    customerUi.CustomerUi(input1);
            }
            else if(countcid == 3){
                    String input4 = "0";
                    for (Customer customer : customers) {
                        if (input1.equals(customer.getCardid())) {
                            customer.setStatus(input4);
                            System.out.println("---------锁卡了，找管理员，再见--------");
                            adminlogin();
                        }
                    }
            }
            else {
                countcid++;
                Welcome_menu();
            }
        }
        countcid = 1;
        }
    public static void main(String[] args) {
        BankSystemUi bankSystemUi = new BankSystemUi();
    }
}
