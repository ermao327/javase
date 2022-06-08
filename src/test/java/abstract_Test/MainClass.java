package abstract_Test;

abstract class A {
    abstract void myMethod(Number N);
}

interface B {
    abstract void myMethod(Object O);
}

class C extends A implements B {
    public void myMethod(Number N) {
        System.out.println("Number");
    }

    public void myMethod(Object O) {
        System.out.println("Object");
    }
}

public class MainClass {
    public static void main(String[] args) {
        A a = new C();
        a.myMethod(new Integer(121));//Number
        B b = new C();
        b.myMethod(new Integer(121));//Object
        C c = new C();
        c.myMethod(new Integer(121));//Number
    }
}