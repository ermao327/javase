package Extends;
//如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句
//任何class的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
//如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
//子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
public class ExtendText01 {
    public static void main(String[] args) {
        int [] refToArray={10,11};
        int var=1;
        refToArray[var-1] = var=2;
        System.out.println(refToArray[0]+"  "+refToArray[1]);

    }
}
