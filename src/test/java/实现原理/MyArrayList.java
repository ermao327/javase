package 实现原理;

import java.util.Arrays;
import java.util.List;

/**
 * 顺序表
 */
public class MyArrayList {

    private Object[] arr = new Object[5];

    private int size;

    public void add(Object obj){
        if(size == arr.length){
           this.arr = Arrays.copyOf(arr, arr.length*2);
        }
        arr[size++] = obj;
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index:"+index);
        }
        return arr[index];
    }

    //将元素添加到头部
    public void addFirst(Object obj){
        if(size == arr.length){
            this.arr = Arrays.copyOf(arr, arr.length*2);
        }
      System.arraycopy(arr, 0, arr, 1, size);
        arr[0]=obj;
        size++;
//        for (int i = size; i >=0 ; i--) {
//            arr[i]=arr[i-1];
//        }
    }
    //指定位置插入元素
    public void add(int index,Object obj){
        if(size == arr.length){
            this.arr = Arrays.copyOf(arr, arr.length*2);
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index:"+index);
        }
        System.arraycopy(arr, index, arr,index+1 , size-index);
        arr[index]=obj;
        size++;

    }
    //将头部元素删除
    public void delFirst(){
        if(size == arr.length){
            this.arr = Arrays.copyOf(arr, arr.length*2);
        }
//        System.arraycopy(arr, 1, arr, 0, size-1);
//        size--;
        for (int i = 0; i < size ; i++) {
            arr[i]=arr[i+1];
        }
        size--;

    }
    //删除指定位置元素
    public void delFirst(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index:"+index);
        }
        if(size == arr.length){
            this.arr = Arrays.copyOf(arr, arr.length *2);
        }
        System.arraycopy(arr, index, arr, index, size-1-index);
        size--;

    }
    //将另一个list中的元素一次性添加到新的list中
    public void addall(int index,MyArrayList list){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index:"+index);
        }
        if(this.size+ list.size >= arr.length){
            this.arr = Arrays.copyOf(arr, (arr.length+list.size)*2);
        }
        System.arraycopy(arr, index, arr, index+list.size, size-index);

        for (int i = 0; i < list.size; i++) {
            this.arr[index+i]=list.get(i);
        }
        size+= list.size;
    }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
//        list.addFirst("qwe");
//        list.delFirst();
//        list.add(2, "qwe");
//        list.delFirst(2);
//        for (int i = 0; i < list.size; i++) {
//            System.out.println(list.get(i));
//        }
        MyArrayList myArrayList1=new MyArrayList();
        myArrayList1.add("111");
        myArrayList1.add("222");
        myArrayList1.add("333");
        myArrayList1.addall(2, list);
        for (int i = 0; i < myArrayList1.size; i++) {
            System.out.println(myArrayList1.get(i));
        }

    }
}
