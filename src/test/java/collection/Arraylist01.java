package collection;

import SYS_User_manage.User;

import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Arraylist01 {

    public static void main(String[] args) {
        List<Student> clazz=new ArrayList<>();
        clazz.add(new Student("占山", "女", 21));
        clazz.add(new Student("占1", "男", 18));
        clazz.add(new Student("占2", "女", 33));
        clazz.add(new Student("占5", "女", 33));
        clazz.add(new Student("占6", "女", 33));
        clazz.add(new Student("占3", "女", 17));

        clazz.removeIf(student -> "女".equals(student.getSex()));
        System.out.println(clazz);




//        int sum=0,count=0;
//        for (Student student : clazz) {
//            if(student.getSex().equals("女"))
//            {
//                count++;
//                sum+=student.getAge();
//            }
//        }
//        System.out.println(sum/count);


//        List<Student> ascList = clazz.stream()
//                .sorted((Comparator.comparingInt(x -> x.getAge())))
//                .collect(Collectors.toList());
//        ascList.forEach(System.out::println);
//        ascList.forEach(s1-> System.out.println(ascList.size()));


//        List<Student> mlist=new ArrayList<>();
//        for (Student student : clazz) {
//            student.getSex().equals("男");
//            mlist.add(student);
//        }
//        System.out.println(mlist);

    }

}
