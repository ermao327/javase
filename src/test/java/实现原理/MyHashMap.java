package 实现原理;

/**
 * 根据某个关键字快速的查询出某个数据
 * 1.哈希码
 * 2.解决散列冲突
 * a.开放定址法 再散列
 * b.再哈希法，有好几个hashcode函数
 * c.拉链法
 * <p>
 * hashmap由一个个桶(数组+单链表)构成
 *
 * JDK HashMap的实现原理
 * 1.由数组+单链表+红黑树构成
 * 2.桶的个数默认是16
 * 3.解决散列冲突用的是拉链法，
 * 当某个桶里的元素个数大于等于8的时候，单链表就会升级为红黑树，
 * 当元素个数由减少到小于等于6的时候，红黑树又会退化成单链表
 * 4.负载因子(loadFactor)0.75,当集合里元素个数超过桶的个数*负载因子，就会扩容
 * 5.插入链表的元素使用的尾插法(以前是头插法)，因为经过测试，发现头插法在多线程的情况下有可能生成循环链表，造成死锁
 */
public class MyHashMap {

    private Entry[] arr = new Entry[5];

    private int size;

    public void put(Object key, Object value) {
        int index = key.hashCode() & (arr.length-1);
        if (null == arr[index]) {
            arr[index] = new Entry(key, value);
            size++;
        } else {
            Entry entry = arr[index];
            while (entry.next != null) {
                entry = entry.next;
            }
            entry.next = new Entry(key, value);
            size++;
        }
    }

    public void printAll(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("----------第"+i+"号桶-------------");
            Entry entry = arr[i];
            while(entry != null){
                System.out.print("["+entry.key+"="+entry.value+"]=>");
                entry = entry.next;
            }
            System.out.println();
        }
    }

    public Object get(Object key) {
//        for (int i = 0; i < keys.length; i++) {
//            if(key.equals(keys[i])){
//                return values[i];
//            }
//        }
        int index = key.hashCode() % arr.length;
        if (arr[index] == null) {
            return null;
        }
        Entry entry = arr[index];
        while(entry != null){
            if (key.hashCode() == entry.key.hashCode() && entry.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void remove(Object key){
        int index = key.hashCode() % arr.length;
        if(arr[index] == null){
            return;
        }
        Entry pre = null;
        Entry entry = arr[index];
        while(entry != null){
            if(key.hashCode() == entry.key.hashCode() &&
                    key.equals(entry.key)){
                //链表的第一个就匹配到了
                if(pre == null){
                    arr[index] = entry.next;
                }
                else {
                    pre.next = entry.next;
                }
                size--;
                return;
            }
            pre = entry;
            entry = entry.next;
        }
    }

    public static void main(String[] args) {
//        System.out.println("bbb".hashCode());
        MyHashMap map = new MyHashMap();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        map.put("ddd", "333");
        map.put("eee", "333");
        map.put("fff", "333");
        map.put("ggg", "333");
        map.put("hhh", "333");
//        System.out.println(map.get("bbb"));
        map.remove("ggg");
        map.printAll();

        System.out.println(100 % 16 ==  (100 & (16-1)));

    }

    public class Entry {

        private Object key;

        private Object value;

        private Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

}