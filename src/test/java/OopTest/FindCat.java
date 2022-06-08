package OopTest;

import java.util.Scanner;

public class FindCat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String catname=scanner.nextLine();
        Cat cat1=new Cat();
        cat1.setName("小白");
        cat1.setCatage(3);
        cat1.setCatcolor("白色");

        Cat cat2=new Cat();
        cat2.setName("小花");
        cat2.setCatage(100);
        cat2.setCatcolor("花色");
        if(catname.equals(cat1.getName()))
            System.out.println(cat1.getName()+" "+cat1.getCatcolor()+" "+cat1.getCatage());
        else if(catname.equals(cat2.getName()))
            System.out.println(cat2.getName()+" "+cat2.getCatcolor()+" "+cat2.getCatage());
        else
            System.out.println("没有这只猫");
    }
}
class Cat{
    private String name;
    private String catcolor;
    private int catage;

    public void setCatage(int catage) {
        this.catage = catage;
    }

    public int getCatage() {
        return catage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCatcolor(String catcolor) {
        this.catcolor = catcolor;
    }

    public String getCatcolor() {
        return catcolor;
    }
}