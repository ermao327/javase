package ebookstore.ui;
import ebookstore.entity.SysUser;
import ebookstore.net.NetClient;
import ebookstore.net.NetMsg;

import java.util.Scanner;

/**
 * 前端
 */
public class ClientUI {
    private boolean loop=true;//控制显示菜单

    private  char key=' ';//接收用户选择

    private NetClient netClient = new NetClient();

    private String ip;

    private int port;

    private Scanner in = new Scanner(System.in);

    public ClientUI(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() throws Exception {
        this.ip = ip;
        this.port = port;
            netClient.start(ip,port);
        goOn();
    }

    //exit退出
    public  void exit(){
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }
    public void goOn(){
        do{
            System.out.println("---------欢迎使用电子图书管理系统-----------");
            System.out.println("请选择 1.登录 2.注册 0.退出");
            key= Utility.readChar();
            switch (key){
                case '1':
                    loginWindow();
                    break;
                case '2':
                    SignUp();
                    break;
                case '0':
                    exit();
                    break;
            }
        }
        while (loop);
    }

    public void SignUp(){//注册，使用jdbc往数据库加入数据
        System.out.println("-----------用户注册-----------");
        System.out.println("请输入用户名:");
        String username = Utility.readString(8);
        System.out.println("请输入密码:");
        String password = Utility.readString(16);
        SysUser sysUser = new SysUser(null, username, password);
        NetMsg<SysUser> request = new NetMsg<>(sysUser, "USER_SIGNUP");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("注册成功");
                mainWindow();
            }
            else if(response.getType().equals("USERNAME_DUP"))
            {
                System.out.println("注册失败。用户名已存在,请重新注册");
                SignUp();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loginWindow(){//登录
        System.out.println("-----------用户登录-----------");
        System.out.println("请输入用户名:");
        String username = Utility.readString(8);
        System.out.println("请输入密码:");
        String password = Utility.readString(16);
        SysUser sysUser = new SysUser(null, username, password);
        NetMsg<SysUser> request = new NetMsg<>(sysUser, "USER_LOGIN");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("登录成功");
                mainWindow();
            }
            else if(response.getType().equals("USERNAME_ERROR"))
            {
                System.out.println("登录失败。用户名不存在,请重新登录");
                loginWindow();
            }
            else{
                System.out.println("登录失败。密码不正确,请重新登录");
                loginWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void mainWindow(){
        do{
            System.out.println("----------主菜单---------");
            System.out.println("请选择 1.图书管理模块 2.客户管理模块 3.订单管理模块 4.主界面 0.退出");
            key= Utility.readChar();
            switch (key){
                case '1':
                    new BookUI(this,this.in,this.netClient);
                    break;
                case '2':
                    new CustomerUI(this,this.in,this.netClient);
                    break;
                case '3':
                    new OrderUI(this,this.in,this.netClient);
                    break;
                case '4':
                    goOn();
                    break;
                case '0':
                    exit();
                    break;
            }
        }
        while (loop);

    }

    public static void main(String[] args) {
        try {
            new ClientUI("localhost",8888).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
