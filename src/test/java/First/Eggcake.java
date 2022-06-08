package First;

public class Eggcake {
    int eggcount;

    public Eggcake(int eggcount) {
        this.eggcount = eggcount;
        System.out.println("有"+this.eggcount+"鸡蛋");
    }
    public  Eggcake(){      //构造方法
        this(1);
    }

    public static void main(String[] args) {
        Eggcake e=new Eggcake();
        Eggcake e1=new Eggcake(3);
    }
}