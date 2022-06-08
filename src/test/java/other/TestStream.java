package other;

import SYS_User_manage.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1.所有的女生
 * 2.按照年龄降序
 * 3.将排好序的所有女生的ID放到一个List中
 * 用之前的学过的写法
 */
public class TestStream {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        List<Student> newlist = new ArrayList<>();
        list.add(new Student("10001", "aaa", "m", 20));
        list.add(new Student("10002", "bbb", "f", 25));
        list.add(new Student("10003", "ccc", "m", 21));
        list.add(new Student("10004", "ddd", "f", 23));
        list.add(new Student("10005", "eee", "m", 22));
        list.add(new Student("10006", "fff", "f", 24));
//----------------------------传统写法---------------------------------
        //遍历循环找出女性
        list.forEach(p->{
            if(p.getSex().equals("f"))
                newlist.add(p);
        });
        System.out.println(newlist);

        //对年龄排序
        Collections.sort(newlist, Comparator.comparing(Student::getAge).reversed());
        System.out.println(newlist);

        //将Student里的id元素抽出来组成一个list
        final List<String> collect = newlist.stream().map(Student::getId).collect(Collectors.toList());
        System.out.println(collect);

//----------------------------stream写法---------------------------------
        final List<String> f = list.stream()
                .filter(student -> student.getSex().equals("f"))//过滤规则
                .sorted(Comparator.comparing(Student::getAge).reversed())//排序规则
                .map(Student::getId)//映射规则
                .collect(Collectors.toList());//收集
        System.out.println(f);

    }

    }

class Student{

    private String id;

    private String name;

    private String sex;

    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
