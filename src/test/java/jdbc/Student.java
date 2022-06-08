package jdbc;

import java.util.Date;

public class Student {

    private Integer id;

    private String name;

    private Date birthday;

    private String sex;

    private Integer age;

    private Double height;

    private Integer tid;

    public Student() {
    }

    public Student(Integer id, String name, Date birthday, String sex, Integer age, Double height, Integer tid) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", tid=" + tid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
