package Extends;

public class Extend01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("张三",12);
        pupil.testing();
        pupil.setScore(68);
        pupil.showInfo();
        System.out.println("-------------------");
        Graduate graduate = new Graduate("李四",21);
        graduate.testing();
        graduate.setScore(86);
        graduate.showInfo();

    }
}
class Stu{
    String name;
    int age;
    private double score;

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public void showInfo(){
        System.out.println("学生名 " + name + " 年龄 " + age + " 成绩 " + score);
    }
}
class Pupil extends Stu{
    public Pupil(String name, int age) {
        super(name, age);
    }
    public void testing(){
        System.out.println("小学生 " + name + "  正在考小学数学..");
    }
}
class Graduate extends Stu{
    public Graduate(String name, int age) {
        super(name, age);
    }
    public void testing(){
        System.out.println("大学生 " + name + " 正在考大学数学..");
    }
}