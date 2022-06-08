package ebookstore.ui;

import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.net.NetClient;
import ebookstore.net.NetMsg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookUI {
    private  ClientUI clientUI;
    private Scanner in;
    private NetClient netClient;
    private boolean loop=true;//控制显示菜单

    private  char key=' ';//接收用户选择

    public BookUI(ClientUI clientUI,Scanner in,NetClient netClient) {
        this.clientUI=clientUI;
        this.in=in;
        this.netClient=netClient;
        bookModular();
    }
    //exit退出
    public  void exit(){
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }
    public void bookModular(){
        do{
            System.out.println("----------图书管理模块---------");
            System.out.println("请选择 1.添加图书 2.删除图书 3.查询图书信息 4.修改图书信息 5.返回上一级菜单 0.退出");
            key= Utility.readChar();
            switch (key){
                case '1':
                    addBook();
                    break;
                case '2':
                    delectBook();
                    break;
                case '3':
                    selectBook();
                    break;
                case '4':
                    modifyBook();
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
    //图书添加模块
    public void addBook(){
        System.out.println("-----------图书添加-----------");
        System.out.println("请输入图书编号:");
        String ISBN = Utility.readString(10);
        System.out.println("请输入书名:");
        String TITLE = Utility.readString(100);
        System.out.println("请输入出版日期:");
        String PUBDATE1 = in.next();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date PUBDATE= null;
        try {
            PUBDATE = format.parse(PUBDATE1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("请输入出版社ID:");
        Integer PUBID = Utility.readIntNum();
        System.out.println("请输入图书成本:");
        double COST = in.nextDouble();
        System.out.println("请输入图书售价:");
        double RETAIL = in.nextDouble();
        System.out.println("请输入图书种别:");
        String CATEGORY = Utility.readString(100);
        SysBook sysBook = new SysBook(ISBN,TITLE,PUBDATE,PUBID,COST,RETAIL,CATEGORY);
        NetMsg<SysBook> request = new NetMsg<>(sysBook, "Book_ADD");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("添加成功");
                bookModular();
            }
            else if(response.getType().equals("BOOK_DUP"))
            {
                System.out.println("添加失败。图书已存在,请重新输入");
                addBook();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //图书修改模块
    public void modifyBook(){
        System.out.println("-----------图书修改-----------");
        System.out.println("请输入需要修改信息的图书编号:");
        String isbn = Utility.readString(10);
        System.out.println("当前的图书信息为:");
        final SysBook sysBook1 = new SysBook();
        sysBook1.setISBN(isbn);
        NetMsg<SysBook> request1 = new NetMsg<>(sysBook1, "Book_SELECT");
        final NetMsg<List<BookPub>> response1;
        try {
            response1 = netClient.send(request1);
            printBooks(response1.getData());//list集合response1.getData()
//            System.out.println(response1.getData().get(0));输出List<BookPub>集合
            response1.getData().forEach(bookPub -> {
                sysBook1.setTITLE(bookPub.getTitle());
                sysBook1.setPUBDATE(bookPub.getPubdate());
                sysBook1.setPUBID(bookPub.getPubid());
                sysBook1.setCOST(bookPub.getCost());
                sysBook1.setRETAIL(bookPub.getRetail());
                sysBook1.setCATEGORY(bookPub.getCategory());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("请输入新图书名称:...不需要修改请按回车");
        String title=sysBook1.getTITLE();
        String TLTLE = Utility.readString(100,"");
        if("".equals(TLTLE))
        {
            TLTLE=title;
        }



        System.out.println("请输入新出版日期:...不需要修改请按回车");
        Date pubdate1=sysBook1.getPUBDATE();
        String PUBDATE1 = Utility.readString(16,"");
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date PUBDATE= null;
        try {
            if("".equals(PUBDATE1))
            {
                PUBDATE=pubdate1;
            }
            else {
                PUBDATE = format.parse(PUBDATE1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        System.out.println("请输入新出版社ID:...不需要修改请按回车");
        Integer pubid=sysBook1.getPUBID();
        Integer PUBID = Utility.readInt(0);
        if(0==PUBID)
        {
            PUBID=pubid;
        }


        System.out.println("请输入新图书成本:...不需要修改请按0");
        double cost = sysBook1.getCOST();
        double COST = in.nextDouble();
        if(0==COST)
        {
            COST=cost;
        }


        System.out.println("请输入新图书售价:...不需要修改请按0");
        double retail = sysBook1.getRETAIL();
        double RETAIL = in.nextDouble();
        if(0==RETAIL)
        {
            RETAIL=retail;
        }

        System.out.println("请输入新图书种别:...不需要修改请按回车");
        String category = sysBook1.getCATEGORY();
        String CATEGORY = Utility.readString(100,"");
        if("".equals(CATEGORY))
        {
            CATEGORY=category;
        }


        SysBook sysBook = new SysBook(isbn,TLTLE,PUBDATE,PUBID,COST,RETAIL,CATEGORY);
        NetMsg<SysBook> request = new NetMsg<>(sysBook, "Book_MODIFY");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("修改成功");
                System.out.println("当前的图书信息为:");
                final SysBook sysBook2 = new SysBook();
                sysBook2.setISBN(isbn);
                NetMsg<SysBook> request2 = new NetMsg<>(sysBook2, "Book_SELECT");
                final NetMsg<List<BookPub>> response2;
                try {
                    response2 = netClient.send(request2);
                    printBooks(response2.getData());//list集合response1.getData()
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bookModular();
            }
            else if(response.getType().equals("BOOK_ERROR"))
            {
                System.out.println("修改失败。图书不存在,请重新输入");
                modifyBook();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //图书查询模块
    public  void selectBook(){

        do{
            System.out.println("-----------图书查询-----------");
            System.out.println("请选择 1.ISBN查询 2.图书名称 3.种类 4.查询所有图书信息 5.返回主菜单 0.退出");
            key= Utility.readChar();
            final SysBook sysBook = new SysBook();
            switch (key){
                case '1':
                    System.out.println("请输入ISBN:");
                    String isbn = Utility.readString(10);
                    sysBook.setISBN(isbn);
                    break;
                case '2':
                    System.out.println("请输入图书名称:");
                    String title = Utility.readString(100);
                    sysBook.setTITLE(title);
                    break;
                case '3':
                    System.out.println("请输入图书种类:");
                    String category = Utility.readString(100);
                    sysBook.setCATEGORY(category);
                    break;
                case '4':
                    break;
                case '5':
                    clientUI.mainWindow();
                case 0:
                    exit();
                    break;
            }
            NetMsg<SysBook> request = new NetMsg<>(sysBook, "Book_SELECT");
            try {
                final NetMsg<List<BookPub>> response = netClient.send(request);
                if(response.getType().equals("SUCCESS")){
                    System.out.println("查询成功");
                    printBooks(response.getData());
                    bookModular();
                }
                else if(response.getType().equals("BOOK_ERROR"))
                {
                    System.out.println("查询失败。没有这本书");
                    selectBook();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (loop);


    }

    private void printBooks(List<BookPub> list){
        System.out.println("ISBN\t\t\t图书名称\t\t\t出版日期\t\t\t出版社\t\t\t成本\t\t\t价格\t\t\t种类");
        list.forEach(book ->
                System.out.println(book.getIsbn()+"\t\t"+book.getTitle()+"\t\t"+book.getPubdate()+
                        "\t\t"+book.getPubname()+"\t\t"+book.getCost()+"\t\t"+book.getRetail()+"\t\t"+book.getCategory()));
    }

    //图书删除模块
    public void delectBook(){
        System.out.println("-----------删除图书-----------");
        System.out.println("请输入图书编号:");
        String isbn = Utility.readString(10);
        SysBook sysBook = new SysBook(isbn);
        NetMsg<SysBook> request = new NetMsg<>(sysBook, "Book_DELETE");
        try {
            final NetMsg response = netClient.send(request);
            System.out.println(response);
            if(response.getType().equals("SUCCESS")){
                System.out.println("删除成功");
                bookModular();
            }
            else if(response.getType().equals("BOOK_ERROR"))
            {
                System.out.println("删除失败。图书不存在,请重新输入编号");
                delectBook();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
