package Story;

//土匪张三抢好人李四10块钱
public class Story {
    public static void main(String[] args) {
        Bandit b =new Bandit("张三", 0);
        GoodPerson g=new GoodPerson("李四",10);
        b.get(g);
        System.out.println(b.money);
        System.out.println(g.money);

    }
}
class Bandit  {
    private String name;
    int money;

    public Bandit(String name,int money) {
        this.name = name;
        this.money = money;
    }
    public void get(GoodPerson g) {
        g.money-=10;
        this.money+=10;
    }
}

class GoodPerson {
    private String name;
    int money;

    public GoodPerson(String name, int money) {
        this.name = name;
        this.money = money;
    }
}