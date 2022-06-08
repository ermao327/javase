package TestLearning;

import java.util.Scanner;

public class Learning02 {
    public static void main(String[] args) {
        Gardener gardener = new Gardener();
        gardener.create();
    }
}
interface Fruit{

}

class Apple implements Fruit{
    public Apple() {
        System.out.println("创建了一个苹果类的对象");
    }
}
class Pear implements Fruit{
    public Pear() {
        System.out.println("创建了一个梨类的对象");
    }
}
class Oranges implements Fruit{
    public Oranges() {
        System.out.println("创建了一个橘子类的对象");
    }
}
class Gardener{
    //接口作为方法返回值的意义：返回实现了该接口的对象
    public Fruit create() {
        Fruit fruit= null;
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        if(str.equals("苹果")) {
            fruit=new Apple();
        }
        if(str.equals("梨")) {
            fruit=new Pear();
        }
        if(str.equals("橘子")) {
            fruit=new Oranges();
        }
        return fruit;

    }
}