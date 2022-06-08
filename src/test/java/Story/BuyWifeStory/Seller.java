package Story.BuyWifeStory;

import java.util.Arrays;

public class Seller {

    private String name;

    private int money;

    private Woman[] women;

    public Woman[] getWomen() {
        return women;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    public Woman sell(int index,int money){
        this.money += money;
        Woman woman = women[index];
        for (int i = index; i < women.length-1; i++) {
                women[i] = women[i+1];
        }
        this.women = Arrays.copyOf(this.women, this.women.length-1);
        return woman;
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

    public Seller(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
