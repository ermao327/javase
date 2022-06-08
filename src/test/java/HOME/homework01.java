package HOME;

import java.util.Arrays;
import java.util.Comparator;

/*定义一个Person类 {name, age, job}, 初始化Person 对象数组，
 有3个person对象，并按照 age 从 大到 小进行排序*/
public class homework01 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0]=new Person("张三", 15, "数据工程师");
        people[1]=new Person("李四", 35, "鼓励师");
        people[2]=new Person("王五", 28, "运维工程师");
/*        //冒泡法：双层循环处理 外层表示 排序次数;内层循环 表示两个相邻元素比较。
        Person tmp = null;
        for (int i = 0; i <people.length-1; i++) {
            for (int j = 0; j <people.length-1-i; j++) {
                if(people[j].getAge()>people[j+1].getAge())
                {
                    tmp=people[j];
                    people[j]=people[j+1];
                    people[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(people));*/

//        Arrays.sort(people);
//        System.out.println(Arrays.toString(people));
        //Comparator接口可以实现自定义排序，实现Comparator接口时，要重写compare方法：
        //int compare(Object o1, Object o2) 返回一个基本类型的整型
        //如果要按照升序排序,则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
        //如果要按照降序排序,则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
        Arrays.sort(people, Comparator.comparing(Person::getAge));
        System.out.println(Arrays.toString(people));

    }
}
class Person implements Comparable{
    private String name;
    private  int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int compareTo(Object o) {
        //compareTo 中定义自己的比较规则
        //
//        如果当前对象this大于形参对象obj，则返回正整数，
//        如果当前对象this小于形参对象obj,则返回负整数。
//        如果当前对象this等于形参对象obj,则返回零。
        Person person=(Person) o;
        return this.age-person.age;
    }
}