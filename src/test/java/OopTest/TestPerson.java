package OopTest;

public class TestPerson {
    public static void main(String[] args) {
        Person p=new Person("张三", 20);
        Person p1=new Person("李四", 30);
        System.out.println(p.compareto(p1));
    }
}
class Person{
    String name;
    int age;

//构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //compareto比较方法
    public  boolean compareto(Person p){
//        if(this.name.equals(p.name)&&this.age==p.age)
//            return true;
//        else
//            return false;
        return this.name.equals(p.name)&&this.age==p.age;
    }
}
