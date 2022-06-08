package First;

public class ID {
    public static void main(String[] args) {
        Person2 p=new Person2("占山", 12);
        System.out.println(p.getAge());
        System.out.println(p.getName());
    }
}
class Person2{
    private String name="666";
    private int age=15;
    public Person2(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
