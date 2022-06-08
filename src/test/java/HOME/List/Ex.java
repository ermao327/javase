package HOME.List;
import javax.naming.Name;
import java.sql.SQLOutput;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 *1.创建10个Person对象，这些对象的所有属性全部是随机生成的
 * id [10000-99999]之间
 * name [a,z]之间，三个字母构成
 * sex [男，女】
 * birthday 年[1990,2020],月[1,12],日[1-30]
 * 2.放到HashMap里，key用id，value是该person对象
 * 3.得到该map所有的学生，放到一个ArrayList中
 * 4.在List中找年龄最大的人
 * 5.按照年龄升序
 */
public class Ex {
    public static int name(int n,int m){
        return (int)(n + Math.random() * (m - n + 1));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Map<String,Person> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
//            ---------------------------------
            String id = (int)(10000 + Math.random() *(99999-10000+1)) + "";
//            -------------------------------------------
            StringBuilder stringBuilder=new StringBuilder();
            for (int j = 0; j <3; j++) {
                char ch =(char)name('a', 'z');
                stringBuilder.append(ch);
            }
            String name=stringBuilder.toString();
//            ------------------------------------------
            int rd=Math.random()>0.5?1:0;
            String sex="男";
            if(rd==1) {sex="男";}
            else {sex="女";}
//            -------------------------------------
            String year = (int)(1990 + Math.random() *(2020-1990+1)) + "";
            String mon = (int)(1 + Math.random() *(12)) + "";
            String day = (int)(1 + Math.random() *(30)) + "";
            String bir=year+"-"+mon+"-"+day;
//            System.out.println(bir);
//            String birthday=df.format(bir);
//            -----------------------------------------------
            map.put(id,new Person(id, name, sex, bir));
        }
//        System.out.println(map);
        ArrayList<Person> people= new ArrayList<>();
        people.addAll(map.values());
        System.out.println(people);
        Collections.sort(people, Comparator.comparing(Person::getBirthday));
        System.out.println(people);

        Person max = Collections.max(people, Comparator.comparing(Person::getBirthday).reversed());
        System.out.println(max);
    }

}

class Person{

    private String id;

    private String name;

    private String sex;

    private String birthday;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Person(String id, String name, String sex, String birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }
}