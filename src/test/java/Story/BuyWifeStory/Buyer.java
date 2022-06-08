package Story.BuyWifeStory;

import java.util.Arrays;

public class Buyer {

    private String name;

    private int money;

    private Woman wife;

    private Child[] children = new Child[3];

    private int childIndex = 0;

    public Buyer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void buy(Seller seller,int index,int money){
        this.money -= money;
        this.wife = seller.sell(index, money);
    }

    public Woman getWife() {
        return wife;
    }

    public void setWife(Woman wife) {
        this.wife = wife;
    }

    public void bear(){
        this.children[childIndex++] = this.wife.bear();
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", wife=" + wife +
                ", children=" + Arrays.toString(children) +
                ", childIndex=" + childIndex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
