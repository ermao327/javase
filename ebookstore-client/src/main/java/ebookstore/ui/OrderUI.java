package ebookstore.ui;

import ebookstore.entity.*;
import ebookstore.net.NetClient;
import ebookstore.net.NetMsg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderUI {
    private  ClientUI clientUI;
    private Scanner in;
    private NetClient netClient;
    private boolean loop=true;//控制显示菜单

    private  char key=' ';//接收用户选择
    public OrderUI(ClientUI clientUI,Scanner in,NetClient netClient) {
        this.clientUI=clientUI;
        this.in=in;
        this.netClient=netClient;
        orderModular();
    }
    //exit退出
    public  void exit(){
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }
    public void orderModular(){
        do {
            System.out.println("----------订单管理模块---------");
            System.out.println("请选择 1.添加订单 2.删除订单 3.查询订单信息 4.修改订单信息 5.返回上一级菜单 0.退出");
            key= Utility.readChar();
            switch (key){
                case '1':
                    addOrder();
                    break;
                case '2':
                    delectOrder();
                    break;
                case '3':
                    selectOrder();
                    break;
                case '4':
                    modifyOrder();
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

    public void addOrder(){
        System.out.println("-----------订单添加-----------");
        System.out.println("-----------我们有这些书，您要买哪一本书----------");
        final SysBook sysBook = new SysBook();
        NetMsg<SysBook> request1 = new NetMsg<>(sysBook, "Book_SELECT");
        final NetMsg<List<BookPub>> response1;
        try {
            response1 = netClient.send(request1);
            printBook(response1.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("请输入图书编号:");
        String ISBN=Utility.readString(10);
        System.out.println("您要购买几本:");
        Integer QUANTITY=Utility.readIntNum3();
        int ITEM1=(int) (1+Math.random()*3);//明细编号随机
        Integer ITEM=ITEM1;

        System.out.println("请输入订单编号:");
        Integer ORDERNO=Utility.readIntNum4();
        System.out.println("请输入客户编号:");
        Integer CUSTOMER=Utility.readIntNum4();
        Date ORSERDATE=new Date();//下单日期为当前
        System.out.println("请输入发货日期:");
        String godate=in.next();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date SHIPDATE=null;
        try {
            SHIPDATE=sdf.parse(godate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("请输入发货地点:");
        String SHIPSTREET=Utility.readString(100,"null");
        System.out.println("请输入发货城市:");
        String SHIPCITY=Utility.readString(100,"null");
        System.out.println("请输入发货省:");
        String SHIPSTATE=Utility.readString(100,"null");
        System.out.println("请输入邮编:");
        String SHIPZIP=Utility.readString(6);
        final SysOrder sysOrder = new SysOrder(ORDERNO, CUSTOMER, ORSERDATE, SHIPDATE,
                SHIPSTREET, SHIPCITY, SHIPSTATE, SHIPZIP);
        NetMsg<SysOrder> request=new NetMsg<>(sysOrder,"ORDER_ADD");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                final SysOrderItems sysOrderItems = new SysOrderItems(ORDERNO,ITEM,ISBN,QUANTITY);
                NetMsg<SysOrderItems> request2=new NetMsg<>(sysOrderItems,"ORDER_ADDD");
                try {
                    final NetMsg response2 = netClient.send(request2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("下单成功");
                orderModular();
            }
            else if(response.getType().equals("ORDER_DUP"))
            {
                System.out.println("下单失败。订单号已存在,请重新输入");
                addOrder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void modifyOrder(){
        System.out.println("-----------订单修改----------");
        System.out.println("请输入订单编号:");
        Integer ORDERNO=Utility.readIntNum4();
        System.out.println("当前的订单信息为:");
        final OrderPub orderPub1 = new OrderPub();
        orderPub1.setORDERNO(ORDERNO);
        NetMsg<OrderPub> request1 = new NetMsg<>(orderPub1, "ORDER_SELECT");
        try {
            final NetMsg<List<OrderPub>> response1 = netClient.send(request1);
            printBooks(response1.getData());
            response1.getData().forEach(orderPub -> {
                orderPub1.setSHIPDATE(orderPub.getSHIPDATE());
                orderPub1.setSHIPSTREET(orderPub.getSHIPSTREET());
                orderPub1.setSHIPCITY(orderPub.getSHIPCITY());
                orderPub1.setSHIPSTATE(orderPub.getSHIPSTATE());
                orderPub1.setSHIPZIP(orderPub.getSHIPZIP());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("修改发货日期:...不需要修改请按回车");
        Date date1 = orderPub1.getSHIPDATE();
        String godate=Utility.readString(16,"");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date SHIPDATE=null;
        try {
            if("".equals(godate))
            {
                SHIPDATE=date1;
            }
            else {
                SHIPDATE = sdf.parse(godate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        System.out.println("修改发货地点:...不需要修改请按回车");
        String shipstreet = orderPub1.getSHIPSTREET();
        String SHIPSTREET=Utility.readString(100,"");
        if("".equals(SHIPSTREET))
        {
            SHIPSTREET=shipstreet;
        }



        System.out.println("修改发货城市:...不需要修改请按回车");
        String shipcity = orderPub1.getSHIPCITY();
        String SHIPCITY=Utility.readString(100,"");
        if("".equals(SHIPCITY))
        {
            SHIPCITY=shipcity;
        }


        System.out.println("修改发货省:...不需要修改请按回车");
        String shipstate = orderPub1.getSHIPSTATE();
        String SHIPSTATE=Utility.readString(100,"");
        if("".equals(SHIPSTATE))
        {
            SHIPSTATE=shipstate;
        }



        System.out.println("修改邮编:...不需要修改请按回车");
        String shipzip = orderPub1.getSHIPZIP();
        String SHIPZIP=Utility.readString(6,"");
        if("".equals(SHIPZIP))
        {
            SHIPZIP=shipzip;
        }


        final SysOrder sysOrder = new SysOrder(ORDERNO, SHIPDATE, SHIPSTREET, SHIPCITY, SHIPSTATE, SHIPZIP);
        NetMsg<SysOrder> request=new NetMsg<>(sysOrder,"ORDER_MODIFY");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("修改成功");
                System.out.println("当前的订单信息为:");
                final OrderPub orderPub2 = new OrderPub();
                orderPub2.setORDERNO(ORDERNO);
                NetMsg<OrderPub> request2 = new NetMsg<>(orderPub2, "ORDER_SELECT");
                try {
                    final NetMsg<List<OrderPub>> response2 = netClient.send(request2);
                    printBooks(response2.getData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                orderModular();
            }
            else if(response.getType().equals("ORDER_ERROR"))
            {
                System.out.println("修改失败。订单号不存在,请重新输入");
                modifyOrder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void selectOrder(){
        do {
            System.out.println("-----------订单查询-----------");
            System.out.println("请选择 1.订单编号查询  2.客户名查询 3.查询所有订单信息 4.返回主菜单 0.退出");
            key= Utility.readChar();
            final OrderPub orderPub = new OrderPub();
            switch (key){
                case '1':
                    System.out.println("请输入订单编号:");
                    Integer orderno = in.nextInt();
                    orderPub.setORDERNO(orderno);
                    break;
                case '2':
                    System.out.println("请输入客户名:");
                    String CUSTOMER_NAME = in.next();
                    orderPub.setCUSTOMER_NAME(CUSTOMER_NAME);
                    break;
                case '3':
                    break;
                case '4':
                    clientUI.mainWindow();
                case '0':
                    exit();
                    break;
            }
            NetMsg<OrderPub> request = new NetMsg<>(orderPub, "ORDER_SELECT");
            try {
                final NetMsg<List<OrderPub>> response = netClient.send(request);
                if(response.getType().equals("SUCCESS")){
                    System.out.println("查询成功");
                    printBooks(response.getData());
                    orderModular();
                }
                else if(response.getType().equals("BOOK_ERROR"))
                {
                    System.out.println("查询失败。没有此订单");
                    selectOrder();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (loop);

    }

    private void printBook(List<BookPub> list){
        System.out.println("ISBN\t\t\t图书名称\t\t\t出版日期\t\t\t出版社\t\t\t成本\t\t\t价格\t\t\t种类");
        list.forEach(book ->
                System.out.println(book.getIsbn()+"\t\t"+book.getTitle()+"\t\t"+book.getPubdate()+
                        "\t\t"+book.getPubname()+"\t\t"+book.getCost()+"\t\t"+book.getRetail()+"\t\t"+book.getCategory()));
    }

    private void printorder(List<SysOrder> list){
        System.out.println("订单编号\t\t\t客户编号\t\t\t下单日期\t\t\t发货日期\t\t\t发货地址\t\t\t发货城市\t\t\t发货省\t\t\t邮编");
        list.forEach(order ->
                System.out.println(order.getORDERNO()+"\t\t"+order.getCUSTOMER()+"\t\t"+order.getORSERDATE()+
                        "\t\t"+order.getSHIPDATE()+"\t\t"+order.getSHIPSTREET()+"\t\t"+order.getSHIPCITY()+
                        "\t\t"+order.getSHIPSTATE()+
                        "\t\t"+order.getSHIPZIP()));
    }

    private void printBooks(List<OrderPub> list){
        System.out.println("订单编号\t\t客户名称\t\t下单日期\t\t发货日期\t\t发货地址\t\t发货城市\t\t发货省\t\t邮编\t\t购买物品");
        list.forEach(order ->
                System.out.println(order.getORDERNO()+"\t\t"+order.getCUSTOMER_NAME()+"\t\t"+order.getORSERDATE()+
                        "\t\t"+order.getSHIPDATE()+"\t\t"+order.getSHIPSTREET()+"\t\t"+order.getSHIPCITY()+
                        "\t\t"+order.getSHIPSTATE()+
                        "\t\t"+order.getSHIPZIP()+
                        "\t\t"+order.getTITLE()));
    }
    public void delectOrder(){
        System.out.println("-----------取消订单-----------");
        System.out.println("请输入订单编号:");
        Integer orderno = Utility.readIntNum4();
        final SysOrder sysOrder = new SysOrder(orderno);
        NetMsg<SysOrder> request = new NetMsg<>(sysOrder, "ORDER_DELETE");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("删除成功");
                orderModular();
            }
            else if(response.getType().equals("ORDER_ERROR"))
            {
                System.out.println("删除失败。订单不存在,请重新输入编号");
                delectOrder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
