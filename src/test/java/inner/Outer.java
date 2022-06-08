package inner;

import javax.swing.*;

/**
 * Outer叫做顶层类
 * Inner就是内部类
 * 1.内部类可以直接使用外部类的属性和方法
 * 2.优先使用静态内部类
 * 3.非静态的内部类不可以定义静态资源
 * 4.静态内部类不可以直接使用外部类的非静态的资源
 * 5.调用静态内部类直接new就行
 * 6.调用非静态内部类需要先调用外部类才能new(先new一个外部类对象)
 * 7.如果内部类中有属性名和外部类相同的，优先使用内部类的属性；如果需要使用外部类的同名属性，先调用外部类
 */
public class Outer {

    private int i = 10;

    public static int s = 20;

    public void outerMethod(){
        System.out.println(new Inner().j);
    }

    public static class StaticInner{

        private int j = 10;

         static int k = 20;

        public void method1(){
//            System.out.println(i);
        }

        public static void method2(){

        }
    }

    public class Inner{

        private int i = 40;

        private int j = 30;

//        private static int s = 50;

        public void innerMethod(){
            System.out.println(Outer.this.i);
            outerMethod();

        }

//        public static void innerMethod2(){
//
//        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();//[6]
//        Inner inner1 = new Outer().new Inner();//[6]
//                StaticInner inner1 = new StaticInner();////[5]
//         inner.innerMethod();
//        System.out.println(inner1.K);


    }
}
