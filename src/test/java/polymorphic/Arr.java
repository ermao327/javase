package polymorphic;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        Student01[] student01 = new Student01[5];
        student01[0]=new Student01("张三",12,"男");
        student01[1]=new Student01("张1",32,"女");
        student01[2]=new Student01("张2",12,"女");
        student01[3]=new Student01("张3",22,"女");
        student01[4]=new Student01("张4",42,"男");
//        Student01 maxage=student01[0];
//        for (Student01 student011 : student01) {
//            if(student011.getAge()> maxage.getAge())
//            { maxage=student011;}
//        }
//        System.out.println(maxage);

        double nan=0,nv=0;
        int count=0,count1=0;
        for (int i = 0; i <student01.length; i++) {
            if(student01[i].getSex().equals("男"))
            {
                nan+=student01[i].getAge();
                count++;
            }
            else
            {
                nv+=student01[i].getAge();
                count1++;
            }

        }
        System.out.println(nan/count+"  "+nv/count1);

    }
}
class Student01{
    private String name;
    private int age;
    private String sex;

    public Student01(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}