package OopTest;

import java.util.Objects;

public class Encap01 {
    //不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则就默认；
    //年龄在1-120之间；name的长度在2-6之间，工资不能直接查看
    public static void main(String[] args) {
        Worker worker = new Worker("张三",250,3000,"sail");
//        worker.setName("张三");
//        worker.setAge(250);
//        worker.setSalary(8968.56);
//        worker.setJob("sail");
        System.out.println(worker.ouput());

    }
}
class Worker{
    public  String name;
    private int age;
    private double salary;
    private String job;

public String ouput(){
    return "name="+this.name+" age="+this.age+" salary="+this.salary+" job="+this.job;
}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Worker(String name,int age, double salary, String job) {
       setName(name);
       setJob(job);
       setSalary(salary);
       setAge(age);
    }

    public void setName(String name) {
        if(name==null||name.isBlank())
            throw  new IllegalArgumentException("invalid name value");
        else if(name.length()>=2&&name.length()<=6)
        this.name = name.strip();// 去掉首尾空格
        else
            throw  new IllegalArgumentException("invalid name value");

    }

    public void setAge(int age) {
        if(age<0||age>120){
//            throw new IllegalArgumentException("invalid age value");//抛出的异常表明向方法传递了一个不合法或不正确的参数。
            System.out.println("请输入正确年龄,已赋值默认值");
            this.age=18;//赋值默认年龄
        }
        else
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}