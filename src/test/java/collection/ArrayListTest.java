package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    //<String>泛型

/**
 * 集合就是用来存对象的
 * 集合里面放的是Object类型
 * 大小可以自动扩容
 */

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("asd");
        list.add("qwe");
        list.add("asd");
        list.add("edc");
        String s = list.get(1);//根据索引来取出元素
        int size = list.size();//容器里元素的个数
        list.remove(1);//删除此列表中指定位置的元素



        
        //多种迭代方法
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String value : list) {
            System.out.println(value);
        }

        for(Iterator<String> iterator=list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

        //函数式编程
        list.forEach(System.out::println);

        //Lambda表达式
        list.forEach(s1-> System.out.println(s1.toUpperCase()));
    }




}
