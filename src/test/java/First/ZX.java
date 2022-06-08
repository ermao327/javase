package First;

public class ZX {
    public static void main(String[] args) {
        Person1 p=new Person1();
        String[] fullname=new  String[]{"Mike","Joke"};
        p.setName(fullname);
        System.out.println(p.getName());
        fullname[0]="Bite";
        System.out.println(p.getName());

        String[] bob=new  String[]{"Bob"};
        p.setName1(bob);
        System.out.println(p.getName1());
        bob[0]="Alice";
        System.out.println(p.getName1());

        int n=15;
        p.setAge(n);
        System.out.println(p.getAge());
        n=20;//创建新的内存地址，将20传入n中；
        p.setAge(n);//加上这段代码就可以改变值
        System.out.println(p.getAge());
/*引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方（因为指向同一个对象嘛）。
* 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
* 都是引用数据类型, 所以编辑是改变之前地址里面的值; 而重新赋值是建立了新的内存, 这时候去get肯定还是之前的内存的值
* String 属于引用类型，直接赋值过去传递的是 bob 的地址，String 类型的值无法修改，重新赋值实际上是又开辟了一片空间，也就是 bob 的指向发生了变化，所以两次输出的值是一样的
* */
    }
}
class Person1{
    private String[] name;

    public String getName() {
        return this.name[0]+"  "+this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }

    private String[] name1;

    public String getName1() {
        return name1[0];
    }

    public void setName1(String[] name1) {
        this.name1 = name1;
    }

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}