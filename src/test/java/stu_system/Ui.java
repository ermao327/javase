package stu_system;

import java.net.IDN;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Ui {
    Scanner scanner=new Scanner(System.in);
    Server server = new Server();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Ui() throws ParseException {
        welcome();
    }

    public void welcome() throws ParseException {
        System.out.println("------------欢迎进入系统---------------");
        menu();
    }
    public void select() throws ParseException {
        System.out.println("请选择:1.查询所有学生信息 2.查询单个学生信息");
        int input=scanner.nextInt();
        if(input==1)
        {
            selectAll();
        }
        else if(input==2)
        {
            selectOne();
        }
        else {
            System.out.println("输入有误");
            select();
        }
    }
    public void selectAll() throws ParseException {
        System.out.println("学号\t姓名\t性别\t生日");
        Student[] students=server.selectAll();
        for (Student student : students) {
            String dateStr= format.format(student.getBirthday());
            System.out.println(student.getId()+"\t"+student.getName()
                    +"\t"+student.getSex()+"\t"+dateStr);
        }
        menu();
    }
    public void selectOne() throws ParseException {
        System.out.println("请输入学生学号");
        String id=scanner.next();
        int b = server.decideInputId(id);
        Student[] students=server.selectOne();
        if(b==-99999)
        {
            boolean flag=true;
            while (flag){
                System.out.println("你查找的这个学生不存在，请选择:1.重新输入 2.返回主菜单 0.退出系统");
                int input=scanner.nextInt();
                switch (input)
                {
                    case 1:
                        flag = false;
                        selectOne();
                        break;
                    case 2:
                        flag = false;
                        menu();
                        break;
                    case 0:
                        flag = false;
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
            }

        }
        else {
            String dateStr = format.format(students[b].getBirthday());
            System.out.println(students[b].getId() + "\t" + students[b].getName()
                    + "\t" + students[b].getSex() + "\t" + dateStr);
            menu();
        }
    }
    public void add() throws ParseException {
        System.out.println("请选择:1.添加一个新学生信息 2.为所有学生添加新字段");
        int input=scanner.nextInt();
        if(input==1)
        {
            addOne();
        }
        else if(input==2)
        {
            addnewfield();
        }
        else {
            System.out.println("输入有误");
            add();
        }
    }

    public void addOne() throws ParseException {
        System.out.println("----请输入新学生的信息-----");
        System.out.println("请输入学号:");
        String id = scanner.next();
        System.out.println("请输入姓名:");
        String name = scanner.next();
        System.out.println("请输入性别:");
        String sex = scanner.next();
        System.out.println("请输入生日(yyyy-MM-dd):");
        String birth = scanner.next();
        Student student = new Student(id, name, sex, format.parse(birth));
        server.addOne(student);
        System.out.println("添加成功");
        menu();

    }
    public void addnewfield() throws ParseException {
        menu();
    }

    public void del() throws ParseException {
        System.out.println("请选择:1.删除单个学生信息 2.删除所有学生信息");
        int input=scanner.nextInt();
        if(input==1)
        {
            delete();
        }
        else if(input==2)
        {
            deleteall();
        }
        else {
            System.out.println("输入有误");
            del();
        }
    }
    public void delete() throws ParseException {
        System.out.println("请输入要删除的学生的学号:");
        String id = scanner.next();
        boolean b = server.deleteById(id);
        if(b){
            System.out.println("删除成功");
            menu();
        }
        else{
            System.out.println("删除失败！请选择:1.重新输入 2.返回到主菜单 0.退出系统");
            boolean flag = true;
            while(true) {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        flag = false;
                        delete();
                        break;
                    case 2:
                        flag = false;
                        menu();
                        break;
                    case 0:
                        System.out.println("正在退出.....");
                        System.exit(0);//JVM停掉了
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
            }
        }
    }
    public void deleteall() throws ParseException {
        System.out.println("----请输入您的工号-----");
        String input=scanner.next();
        Student[] students=server.deletebefore();
        int b = server.TeacherDecideInputId(input);
        if(b==-99999)
        {
            boolean flag=true;
            while (flag){
                System.out.println("你的工号不存在，请选择:1.重新输入 2.返回主菜单 0.退出系统");
                int input1=scanner.nextInt();
                switch (input1)
                {
                    case 1:
                        flag = false;
                        deleteall();
                        break;
                    case 2:
                        flag = false;
                        menu();
                        break;
                    case 0:
                        flag = false;
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
            }
        }
        else {
            students[b]=students[0];
            server.delall(students[b]);
            System.out.println("删除成功");
            menu();
        }

    }
    public void modify() throws ParseException {
        System.out.println("请选择:1.修改学生的单个信息 2.修改学生全部信息");
        int input=scanner.nextInt();
        if(input==1)
        {
            modifyOne();
        }
        else if(input==2)
        {
            modifyAll();
        }
        else {
            System.out.println("输入有误");
            modify();
        }
    }
    public void modifyOne() throws ParseException {
        System.out.println("请输入需要修改信息的学生学号");
        String input=scanner.next();
        Student[] students=server.modifyOne();
        for (int i = 0; i <students.length; i++) {
            if(input.equals(students[i].getId())) {
                System.out.println("请选择需要修改学生的哪个信息");
                System.out.println("请选择:1.学号 2.姓名 3.性别 4.入学日期");
                int input1=scanner.nextInt();
                switch (input1){
                    case 1:
                        System.out.println("请输入新的学号:");
                        String id = scanner.next();
                        Student student = new Student(id, students[i].getName(),
                                students[i].getSex(), students[i].getBirthday());
                        students[i]=student;
                        break;
                    case 2:
                        System.out.println("请输入新的姓名:");
                        String name = scanner.next();
                        Student student1 = new Student(students[i].getId(), name,
                                students[i].getSex(), students[i].getBirthday());
                        students[i]=student1;
                        break;
                    case 3:
                        System.out.println("请输入新的性别:");
                        String sex = scanner.next();
                        Student student2 = new Student(students[i].getId(),
                                students[i].getName(), sex, students[i].getBirthday());
                        students[i]=student2;
                        break;
                    case 4:
                        System.out.println("请输入新的生日(yyyy-MM-dd):");
                        String birth = scanner.next();
                        Student student3 = new Student(students[i].getId(),
                                students[i].getName(), students[i].getSex(), format.parse(birth));
                        students[i]=student3;
                        break;
                }menu();
            }

        }

    }
    public void modifyAll() throws ParseException {
        System.out.println("请输入需要修改信息的学生学号");
        String input=scanner.next();
        int b = server.decideInputId(input);
        Student[] students=server.modifyAll();
        if(b==-99999)
        {
            boolean flag=true;
            while (flag){
                System.out.println("你要修改的学生不存在，请选择:1.重新输入 2.返回主菜单 0.退出系统");
                int input1=scanner.nextInt();
                switch (input1)
                {
                    case 1:
                        flag = false;
                        deleteall();
                        break;
                    case 2:
                        flag = false;
                        menu();
                        break;
                    case 0:
                        flag = false;
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请重新输入！");
                }
            }
        }
        else{
            System.out.println("请输入新的学生信息");
            System.out.println("请输入新的学号:");
            String id = scanner.next();
            System.out.println("请输入新的姓名:");
            String name = scanner.next();
            System.out.println("请输入新的性别:");
            String sex = scanner.next();
            System.out.println("请输入新的生日(yyyy-MM-dd):");
            String birth = scanner.next();
            Student student = new Student(id, name, sex, format.parse(birth));
            String dateStr= format.format(students[b].getBirthday());
            students[b]=student;
            System.out.println(students[b].getId()+"\t"+students[b].getName()
                    +"\t"+students[b].getSex()+"\t"+dateStr);
            System.out.println("修改成功");
            menu();
        }

    }
    public  void menu() throws ParseException {
        System.out.println("请选择:1.查询学生信息 2.添加学生信息 3.修改学生信息 4.删除学生信息 0.退出");
        int input=scanner.nextInt();
        switch (input){
            case 1:
                select();
                break;
            case 2:
                add();
                break;
            case 3:
                modify();
                break;
            case 4:
                del();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("您输入有误!请重新输入");
                menu();

        }
    }
    public static void main(String[] args) throws ParseException {
        Ui ui = new Ui();
    }
}
