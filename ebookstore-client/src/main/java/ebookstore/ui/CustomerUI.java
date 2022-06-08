package ebookstore.ui;

import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.entity.SysCustomer;
import ebookstore.net.NetClient;
import ebookstore.net.NetMsg;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {
    private  ClientUI clientUI;
    private Scanner in;
    private NetClient netClient;
    private boolean loop=true;//控制显示菜单

    private  char key=' ';//接收用户选择

    public CustomerUI(ClientUI clientUI,Scanner in,NetClient netClient) {
        this.clientUI=clientUI;
        this.in=in;
        this.netClient=netClient;
        customerModular();
    }
    //exit退出
    public  void exit(){
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }
    public void customerModular(){
        do {
            System.out.println("----------客户管理模块---------");
            System.out.println("请选择 1.添加客户 2.删除客户 3.查询客户信息 4.修改客户信息 5.返回上一级菜单 0.退出");
            key= Utility.readChar();
            switch (key){
                case '1':
                    addCustomer();
                    break;
                case '2':
                    delectCustomer();
                    break;
                case '3':
                    selectCustomer();
                    break;
                case '4':
                    modifyCustomer();
                    break;
                case '5':
                    clientUI.mainWindow();
                    break;
                case '0':
                    exit();
                    break;
            }
        }while (loop);

    }

    public void addCustomer(){
        System.out.println("-----------客户添加-----------");
        System.out.println("请输入客户编号:");
        Integer CUSTOMER = Utility.readIntNum4();
        System.out.println("请输入客户姓名:");
        String CUSTOMER_NAME = Utility.readString(20);
        System.out.println("请输入顾客所在城市:");
        String CITY = Utility.readString(50,"null");
        System.out.println("请输入顾客所在省:");
        String STATE = Utility.readString(50,"null");
        System.out.println("请输入邮政编码:");
        String ZIP = Utility.readString(6);
        System.out.println("请输入推荐会员:");
        Integer REFERRED = Utility.readIntNum4();
        System.out.println("请输入顾客电话:");
        String TEL_NO =Utility.readString(15,"null");
        System.out.println("请输入顾客地址:");
        String ADDRESS = Utility.readString(200);
        final SysCustomer sysCustomer = new SysCustomer(CUSTOMER, CUSTOMER_NAME, CITY, STATE,
                ZIP, REFERRED, TEL_NO, ADDRESS);
        NetMsg<SysCustomer> request = new NetMsg<>(sysCustomer, "CUSTOMER_ADD");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("添加成功");
                customerModular();
            }
            else if(response.getType().equals("CUSTOMER_DUP"))
            {
                System.out.println("添加失败。客户已存在,请重新输入");
                addCustomer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void modifyCustomer(){
        System.out.println("-----------客户信息修改-----------");
        System.out.println("请输入需要修改信息的客户编号:");
        Integer CUSTOMER = Utility.readIntNum4();
        System.out.println("当前的客户信息为:");
        final SysCustomer sysCustomer1 = new SysCustomer();
        sysCustomer1.setCUSTOMER(CUSTOMER);
        NetMsg<SysCustomer> request1 = new NetMsg<>(sysCustomer1, "CUSTOMER_SELECT");
        final NetMsg<List<SysCustomer>> response1;
        try {
            response1 = netClient.send(request1);
            printCustomer(response1.getData());
            response1.getData().forEach(sysCustomer -> {
                sysCustomer1.setCUSTOMER_NAME(sysCustomer.getCUSTOMER_NAME());
                sysCustomer1.setCITY(sysCustomer.getCITY());
                sysCustomer1.setSTATE(sysCustomer.getSTATE());
                sysCustomer1.setZIP(sysCustomer.getZIP());
                sysCustomer1.setREFERRED(sysCustomer.getREFERRED());
                sysCustomer1.setTEL_NO(sysCustomer.getTEL_NO());
                sysCustomer1.setADDRESS(sysCustomer.getADDRESS());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("请输入新客户姓名:...不需要修改请按回车");
        String customer_name= sysCustomer1.getCUSTOMER_NAME();
        String CUSTOMER_NAME = Utility.readString(20,"");
        if("".equals(CUSTOMER_NAME))
        {
            CUSTOMER_NAME=customer_name;
        }


        System.out.println("请输入新顾客所在城市:...不需要修改请按回车");
        String city = sysCustomer1.getCITY();
        String CITY = Utility.readString(50,"");
        if("".equals(CITY))
        {
            CITY=city;
        }


        System.out.println("请输入新顾客所在省:...不需要修改请按回车");
        String state = sysCustomer1.getSTATE();
        String STATE = Utility.readString(50,"");
        if("".equals(STATE))
        {
            STATE=state;
        }


        System.out.println("请输入新邮政编码:...不需要修改请按回车");
        String zip = sysCustomer1.getZIP();
        String ZIP = Utility.readString(6,"");
        if("".equals(ZIP))
        {
            ZIP=zip;
        }


        System.out.println("请输入新推荐会员:...不需要修改请按回车");
        Integer referred = sysCustomer1.getREFERRED();
        Integer REFERRED = Utility.readInt4(0);
        if(0==REFERRED)
        {
            REFERRED=referred;
        }

        System.out.println("请输入新顾客电话:...不需要修改请按回车");
        String tel_no = sysCustomer1.getTEL_NO();
        String TEL_NO =Utility.readString(15,"");
        if("".equals(TEL_NO))
        {
            TEL_NO=tel_no;
        }

        System.out.println("请输入新顾客地址:...不需要修改请按回车");
        String address = sysCustomer1.getADDRESS();
        String ADDRESS = Utility.readString(200,"");
        if("".equals(ADDRESS))
        {
            ADDRESS=address;
        }

        final SysCustomer sysCustomer = new SysCustomer(CUSTOMER, CUSTOMER_NAME, CITY, STATE,
                ZIP, REFERRED, TEL_NO, ADDRESS);
        NetMsg<SysCustomer> request = new NetMsg<>(sysCustomer, "CUSTOMER_MODIFY");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("修改成功");
                System.out.println("当前的客户信息为:");
                final SysCustomer sysCustomer2 = new SysCustomer();
                NetMsg<SysCustomer> request2 = new NetMsg<>(sysCustomer2, "CUSTOMER_SELECT");
                final NetMsg<List<SysCustomer>> response2;
                try {
                    response2 = netClient.send(request1);
                    printCustomer(response2.getData());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                customerModular();
            }
            else if(response.getType().equals("CUSTOMER_ERROR"))
            {
                System.out.println("修改失败。客户不存在,请重新输入");
                modifyCustomer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCustomer(){
        do {
            System.out.println("-----------客户查询-----------");
            System.out.println("请选择 1.编号查询 2.姓名查询 3.所有客户信息 4.返回主菜单 0.退出");
            key= Utility.readChar();
            final SysCustomer sysCustomer = new SysCustomer();
            switch (key){
                case '1':
                    System.out.println("请输入客户编号:");
                    Integer CUSTOMER = Utility.readIntNum4();
                    sysCustomer.setCUSTOMER(CUSTOMER);
                    break;
                case '2':
                    System.out.println("请输入客户姓名:");
                    String CUSTOMER_NAME = Utility.readString(20);
                    sysCustomer.setCUSTOMER_NAME(CUSTOMER_NAME);
                    break;
                case '3':
                    break;
                case '4':
                    clientUI.mainWindow();
                case '0':
                    exit();
                    break;
            }
            NetMsg<SysCustomer> request = new NetMsg<>(sysCustomer, "CUSTOMER_SELECT");
            try {
                final NetMsg<List<SysCustomer>> response = netClient.send(request);
                if(response.getType().equals("SUCCESS")){
                    System.out.println("查询成功");
                    printCustomer(response.getData());
                    customerModular();
                }
                else if(response.getType().equals("CUSTOMER_ERROR"))
                {
                    System.out.println("查询失败。没有此用户");
                    selectCustomer();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (loop);

    }
    private void printCustomer(List<SysCustomer> list){
        System.out.println("顾客编号\t\t顾客姓名\t\t所在城市\t\t所在省\t\t邮政编码\t\t推荐会员\t\t顾客电话\t\t顾客地址");
        list.forEach(Customer ->
                System.out.println(Customer.getCUSTOMER()+"\t\t"+Customer.getCUSTOMER_NAME()+"\t\t\t"+Customer.getCITY()+
                        "\t\t\t"+Customer.getSTATE()+"\t\t\t"+Customer.getZIP()+"\t\t"+Customer.getREFERRED()
                        +"\t\t"+Customer.getTEL_NO()+"\t\t"+Customer.getADDRESS()));
    }

    public void delectCustomer(){
        System.out.println("-----------删除客户-----------");
        System.out.println("请输入客户编号:");
        Integer CUSTOMER = Utility.readIntNum4();
        final SysCustomer sysCustomer = new SysCustomer(CUSTOMER);
        NetMsg<SysCustomer> request = new NetMsg<>(sysCustomer, "CUSTOMER_DELETE");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("删除成功");
                customerModular();
            }
            else if(response.getType().equals("CUSTOMER_ERROR"))
            {
                System.out.println("删除失败。客户不存在,请重新输入编号");
                delectCustomer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
