package HouseRentSys;

import HouseRentSys.View.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //程序入口，创建HouseView对象，显示主界面
        new HouseView().mainMenu();
        System.out.println("退出房屋系统..........");
    }
}
