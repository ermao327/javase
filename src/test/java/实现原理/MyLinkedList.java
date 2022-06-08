package 实现原理;
import org.w3c.dom.Node;

import javax.crypto.interfaces.PBEKey;

public class MyLinkedList {
    private Node first;
    private int size;
    public  void addFirst(Object obj){
        Node node=new Node();
        node.obj = obj;
                if(first==null)
                {
                    first=node;
                    size++;
                }
                else {

                    node.next=first;
                    first=node;
                    size++;
                }
    }
    public  void addlast(Object obj){
        Node node=new Node();
        node.obj = obj;
        if(first==null)
        {
            first=node;
            size++;
        }
        else {
            Node temp=first;
            while (temp.next!=null)
            {
                temp=temp.next;
            }
           temp.next=node;
            size++;
        }
    }
    public Object get(int index){
//        Node temp=first.txt;
//        for (int i = 0; i < index; i++) {
//            temp=temp.next;
//        }
//        return  temp.obj;
        Node node=getNode(index);
        return node.obj;
    }

    //找下标球
    private  Node getNode(int index){
        Node temp=first;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }
    public void printall(){
        Node temp=first;
        while (temp!=null)
        {
            System.out.println(temp.obj);
            temp=temp.next;

        }
    }
    public void removeFirst(){
        Node second=this.first.next;
        this.first.next=null;
        this.first=second;
        size--;
    }
    public void removeLast(){
        if(first==null)
        {
            return;
        }
        if(first.next==null)
        {
            first=null;
            size--;
            return;
        }
        Node temp=first;
        while (temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }


    public void add(int index,Object obj){
        Node newnode=new Node();
        newnode.obj=obj;
        Node pre =getNode(index-1);
        newnode.next=pre.next;
        pre.next=newnode;
        size++;
    }

    public void del(int index){
        if(first==null)
        {return;}
        Node pre=getNode(index-1);
        if(pre.next==null){return;}
        pre.next=pre.next.next;
        size--;
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst("aaa");
        myLinkedList.addFirst("bbb");
        myLinkedList.addFirst("ccc");
//        System.out.println(myLinkedList.get(1));

//        myLinkedList.addlast("qwe");
//        myLinkedList.removeFirst();
//        myLinkedList.removeLast();
                myLinkedList.printall();

    }
    private class Node{

        private Object obj;

        private Node next;
    }
}
