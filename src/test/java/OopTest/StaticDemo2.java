package OopTest;

public class StaticDemo2{
  static   String name="张三";
  static {
//      静态代码块：
//      通常用于初始化静态属性
//      1、可以有输出语句
//      2、可以对类的属性、类的声明进行初始化操作
//      3、不可以对非静态的属性进行初始化
//      4、多个静态代码块，由上到下依次执行
//      5、静态代码块的执行先于非静态代码块
//      6、静态代码块随类的加载而加载，且只执行一次

//      String name="张";//作用域仅在这个静态代码块
//      name="123";//对name变量赋值，因name为静态变量，作用域为全局
        System.out.println("静态代码块"+name);
    }
    {
//        非静态代码块：
//        1、可以有输出语句
//        2、可以对类的属性、类的声明进行初始化操作、可以初始化类的实例变量
//        3、可以对非静态的属性进行初始化，也可以对静态的变量和方法进行调用
//        4、多个非静态代码块，由上到下依次执行
//        5、非静态代码块是在类被实例化的时候执行的，类每实例化一次，则非静态代码块执行一次
//        优先于构造器

       String name="qwe";//作用域仅在这个静态代码块
//        name="qwe";//对name变量赋值，因name为静态变量，作用域为全局
        System.out.println("非静态代码块"+name);
    }
    public StaticDemo2(String name){
//      this.name = name;
//      name=name;
      name=this.name;
        System.out.println("构造方法"+name);
    }

    public  void show(){
       System.out.println("成员方法"+name);
   }

    public static void main(String[] args) {
        StaticDemo2 d=new StaticDemo2("abc");
        d.show();
//        StaticDemo2 d1=new StaticDemo2();
    }
}
