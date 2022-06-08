package Second;

import java.util.Arrays;

public class QD {
    public static void main(String[] args) {
        Person ming=new Person();
        ming.setName("zhangs");
        ming.setAge(55);
        System.out.println(ming.getName() + ", " + ming.getAge());
        ming.setBirth(2008);
        System.out.println(ming.getAge());
        ming.setNames("里斯","占山");
        System.out.println(Arrays.toString(ming.getNames()));//Arrays.toString（）的作用是用来很方便地输出数组，而不用一个一个地输出数组中的元素

    }
}
class Person{
    private String name;
    private int age;
    private int birth;
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name==null||name.isBlank())
        {
            throw  new IllegalArgumentException("invalid name value");
        }
        this.name = name.strip();// 去掉首尾空格
    }

    public int getAge() {
        return calcAge(2019);
    }

    public void setAge(int age) {
        if(age<0||age>100){
            throw new IllegalArgumentException("invalid age value");//抛出的异常表明向方法传递了一个不合法或不正确的参数。
        }
        this.age = age;
    }
}