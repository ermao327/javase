package Extends;

public class SortingTest {
    public static void main(String[] args) {
        Child p = new Child("小明", 12);
        Student s = new Student("小红", 20, 99);
        // TODO: 定义PrimaryStudent，从Student继承，新增grade字段:
        Student ps = new PrimaryStudent("小军", 9, 100, 5);
        System.out.println(ps.getScore());

    }
}
class Child{
    protected String name;
    protected int age;
    public Child(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Child{
    protected int score;

    public int getScore() {

        return score;
    }

   public Student(String name,int age,int score){
        super(name,age);
        this.score=score;
   }
}
class PrimaryStudent extends Student{
    protected int grade;

    public PrimaryStudent(String name, int age, int score,int grade) {
        super(name, age, score);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}