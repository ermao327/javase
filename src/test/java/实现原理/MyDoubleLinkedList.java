package 实现原理;
//双向链表实现原理
public class MyDoubleLinkedList {

    //头结点
    private DNode first;

    //尾结点
    private DNode last;

    private int size;

    public void addFirst(Object obj){
        DNode node = new DNode();
        node.obj = obj;
        if(first == null){
            this.first = node;
            this.last = node;
            this.size++;
        }
        else{
            this.first.pre = node;
            node.next = this.first;
            this.first = node;
            size++;
        }
    }

    public void addLast(Object obj){
        DNode node = new DNode();
        node.obj = obj;
        if(first == null){
            this.first = node;
            this.last = node;
            this.size++;
        }
        else{
           this.last.next=node;
           node.pre=this.last;
           this.last=node;
            size++;
        }
    }

    public void delFirst(){
        DNode second=this.first.next;
        this.first.next=null;
        this.first=second;
        this.first.pre=null;
        size--;
    }
    public void delLastt(){
        DNode second=this.last.pre;
        this.first.pre=null;
        this.last=second;
        this.last.next=null;
        size--;
    }
//插入时不能插头和尾，否为空指针错误，BUG
    public void addindex(int index,Object obj)
    {
        DNode newnode=new DNode();
        newnode.obj=obj;
        DNode curr = getNode(index);
        newnode.next=curr;
        curr.pre.next=newnode;
        newnode.pre=curr.pre;
        curr.pre=newnode;
        size++;
    }
    public void delindex(int index){
        DNode curr=getNode(index);
        curr.next.pre=curr.pre;
        curr.pre.next=curr.next;
        curr.pre=null;
        curr.next=null;
        size--;
    }

    public Object get(int index){
        return getNode(index).obj;
    }

    private DNode getNode(int index){
        //从左往右找
         if(index < size / 2){
            DNode temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        //从右往左找
        else{
            DNode temp = last;
            for (int i = size-1; i > index; i--) {
                temp = temp.pre;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.addFirst("aaa");
        linkedList.addFirst("bbb");
        linkedList.addFirst("ccc");
//        linkedList.addLast("qwe");
//        linkedList.delFirst();
//        linkedList.delLastt();
        linkedList.addindex(1, "edc");
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }
    }

    private class DNode{

        private Object obj;

        private DNode pre;

        private DNode next;
    }
}
