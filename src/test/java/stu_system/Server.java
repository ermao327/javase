package stu_system;

import java.util.Arrays;
import java.util.Date;

public class Server {
    private Student[] students = new Student[5];
    private Teacher[] teachers = new Teacher[3];
    public Server() {
        students[0] = new Student("111", "aaa", "男", new Date());
        students[1] = new Student("333", "bbb", "女", new Date());
        students[2] = new Student("555", "ccc", "男", new Date());
        students[3] = new Student("444", "ddd", "女", new Date());
        students[4] = new Student("222", "eee", "男", new Date());
        teachers[0] = new Teacher("001");
        teachers[1] = new Teacher("002");
        teachers[2] = new Teacher("003");
    }
    public Student[] selectAll(){
        return this.students;
    }
    public Student[] selectOne(){
        return this.students;
    }
    public void addOne(Student student){
        students= Arrays.copyOf(students, students.length+1);
        students[students.length-1]=student;
    }
    public Student[] modifyOne(){
        return this.students;
    }
    public Student[] modifyAll(){
        return this.students;
    }
    public Student[] deletebefore(){
        return this.students;
    }
//    public void del(Student student){
//        students= Arrays.copyOf(students, students.length-1);
//    }
    public void delall(Student student){
        students= Arrays.copyOf(students, 0);
    }
    public int decideInputId(String id){
        for (int i = 0; i <students.length; i++) {
            if(id.equals(students[i].getId())){
                return i;
            }
        }
        return -99999;
    }
    public int TeacherDecideInputId(String id){
        for (int i = 0; i <teachers.length; i++) {
            if(id.equals(teachers[i].getId())){
                return i;
            }
        }
        return -99999;
    }
    public boolean deleteById(String id){
        boolean flag = false;
        for (int i = 0; i < students.length; i++) {
            if(id.equals(students[i].getId())){
                flag = true;
                for (int j = i; j < students.length-1; j++) {
                    students[j] = students[j+1];//往左移动
                }
                break;
            }
        }
        if(flag) {
            students = Arrays.copyOf(students, students.length - 1);
            return true;
        }
        return false;
    }
}
