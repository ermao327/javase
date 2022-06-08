package HOME;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/*1）	创建一个HashSet，往里面依次放入”Java”、”is”、”my”、”whole”、”life”5个字符串；(4分)
        2）	将上题的Set中的内容复制到一个ArrayList中；(2分)
        3）	迭代上题的List中的字符串，并且每2秒控制台打印一个字符串；（4分）*/

public class new1 {
    private static int i=0;
    public static void main(String[] args) throws InterruptedException {
        final HashSet<String> hash = new HashSet<>();
        hash.add("Java");
        hash.add("is");
        hash.add("my");
        hash.add("whole");
        hash.add("life");
        final ArrayList<String> list = new ArrayList<>();
        hash.forEach(hasd1->{
            list.add(hasd1);
        });
        System.out.println(list);
        list.forEach(list1->{
            System.out.println(list.get(i));
            try {
                Thread.sleep(2000);i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
