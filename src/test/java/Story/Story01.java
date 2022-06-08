package Story;

public class Story01 {
    //学生张三向学生李四借了10块钱
    public static void main(String[] args) {
        Student zs = new Student("张三", 0);
        Student ls = new Student("李四", 100);
        System.out.println(zs);
        System.out.println(ls);
        zs.borrow(ls,10);
        System.out.println("----------借钱之后----------");
        System.out.println(zs);
        System.out.println(ls);

    }
}
class Student {

    private String name;

    private int money;

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void borrow(Student student,int money){
        student.lend(this,money);
    }

    public void lend(Student student,int money){
        this.money -= money;
        student.money += money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}