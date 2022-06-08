package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 映射集
 * key-value
 * map的key
 * 1.不可以重复，新的会覆盖旧的，value是可以重复的
 * 2.map的key是无序的
 * 3.允许一个key是null
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        map.put("ddd", 444);
        map.put("eee", 555);
        map.put("eee", 666);//不可以重复，新的会覆盖旧的
        map.put(null, 777);
        Integer ccc=map.get("ccc");
        System.out.println(ccc);


        //1.先得到key的集合。然后依次得到key对应的value
        Set<String> keyset=map.keySet();
        for (String key : keyset) {
            System.out.println(key+"="+map.get(key));
        }

        //2.如果只想迭代value
        Collection<Integer>values=map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        //3.Entry（一对键值对）
        Set<Map.Entry<String,Integer>> enteries =map.entrySet();
        for (Map.Entry<String, Integer> entery : enteries) {
            System.out.println(entery.getKey()+"="+entery.getValue());
        }

    }
}
