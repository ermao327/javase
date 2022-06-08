package Extends;

public class Pad extends Computer {
    String barrty="5000A";
    public Pad(){
        super();
        this.screen=super.screen;
    }
    void open3g(){
        System.out.println("打开4g");
    }
    void  showpic(){
        System.out.println("平板，手机触摸");
    }
    String sayhello(){
        return super.sayhello()+"平板";
    }
}
