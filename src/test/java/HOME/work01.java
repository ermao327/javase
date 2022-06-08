package HOME;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.有一个熊猫数组，里面有10只
 * 2.每一只熊猫的姓名由三个英文小写字母构成(随机产生)
 * 3.每一只熊猫的体重【50-200】，也是随机产生
 * 4.找到最重的那只熊猫并打印它的信息
 * 5.对该数组按照体重进行降序
 */
public class work01 {
    public static int Pandaheight(int n,int m){
        return (int)(n + Math.random() * (m - n + 1));
    }
    public static int Pandaname(int n,int m){
        return (int)(n + Math.random() * (m - n + 1));
    }
    public static void main(String[] args) {
        Panda[] Pandas = new Panda[10];
        for (int i = 0; i <Pandas.length; i++) {
            StringBuilder stringBuilder=new StringBuilder();
            for (int j = 0; j <3; j++) {
                char ch =(char)Pandaname('a', 'z');
                stringBuilder.append(ch);
            }
            String pname=stringBuilder.toString();
            Integer pheight =(int) Pandaheight(50, 200);
            Pandas[i] = new Panda(pname, pheight);
        }
        Arrays.sort(Pandas);
        System.out.println(Pandas[0]);
        System.out.println(Arrays.toString(Pandas));
    }

}
class Panda implements Comparable{
    private String name;
    private Integer weight;

    public Panda(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Panda pandon=(Panda) o;
//        return this.weight-pandon.weight;//升序
        return pandon.weight-this.weight;//降序
    }
}
