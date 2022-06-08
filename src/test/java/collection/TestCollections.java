package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<Student> clazz = new ArrayList<>();
        clazz.add(new Student("aaa", "m", 21));
        clazz.add(new Student("bbb", "f", 23));
        clazz.add(new Student("ccc", "m", 22));
        clazz.add(new Student("ddd", "f", 19));

        Student max = Collections.max(clazz, Comparator.comparing(Student::getAge));
        System.out.println(max);


//        Collections.sort(clazz, Comparator.comparing(Student::getAge));//升序
//        System.out.println(clazz);
//        Collections.sort(clazz, Comparator.comparing(Student::getAge).reversed());//降序
//        System.out.println(clazz);
//        Collections.reverse(clazz);//反转
//        System.out.println(clazz);

    }
}
