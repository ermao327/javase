package Listwork;

import java.util.*;

public class SortWord {
//    从控制台输入若干个单词（输入#结束）放入ArrayList中，
//    将这些单词排序后（忽略大小写）打印出来。
    List<String> list=new ArrayList<>();
    Scanner input=new Scanner(System.in);
    boolean flag=true;
    String temp=null;

    public static void main(String[] args) {
        new SortWord().write();
    }

    public void write() {
        do {
            System.out.println("请输入若干单词，一次输入多个视为一组（输入#结束）：");
            temp=input.next();
            if(temp.equals("#")) {
                flag=false;
            }else {
                list.add(temp);
            }
        }while(flag);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <list.size()-1-i; j++) {

                if(list.get(j).toUpperCase().compareTo(list.get(j+1).toUpperCase())>0) {
                    temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1, temp);
                }//if
            }//for
        }//for

        System.out.println("以下是从小到大的单词排序");
        for (String str : list) {
            System.out.print(str+"\t");
        }

    }
}

