package polymorphic;

public class PolyText01 {
    public static void main(String[] args) {
        Person p = new Student1();
        p.run(); // 应该打印Person.run还是Student.run?
    }
}

class Person {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student1 extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}
