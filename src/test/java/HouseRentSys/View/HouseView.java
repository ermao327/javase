package HouseRentSys.View;

import HouseRentSys.Domain.House;
import HouseRentSys.Service.HouseService;
import HouseRentSys.Utils.Utility;

/*
1.显示界面
2.接受用户的输入
3.调用HouseService完成对房屋信息的crud
*/
public class HouseView {
    private boolean loop=true;//控制显示菜单
    private  char key=' ';//接收用户选择
    //设置数组大小为10
    private HouseService houseService=new HouseService(10);


//modifyHouse   在findById方法中调用id返回值，存在直接set修改
//根据id修改
    public void modifyHouse(){
        System.out.println("------------修改房源----------------");
        System.out.println("请输入待修改的房屋编号(-1退出)");
        int modifyId=Utility.readInt();
        if(modifyId==-1){
            System.out.println("放弃修改房源信息");
            return;
        }
        House house = houseService.findById(modifyId);
        if(house==null)
        {
            System.out.println("需要修改房源信息的id不存在");
            return;
        }
        System.out.println("姓名("+house.getName()+"):");
        //如果直接回车表示不修改
        System.out.println("不需要修改请按回车");
        String name=Utility.readString(8, "");
        if(!"".equals(name))
        {
            house.setName(name);
        }
        System.out.println("电话("+house.getPhone()+"):");
        System.out.println("不需要修改请按回车");
        String phone=Utility.readString(11, "");
        if(!"".equals(phone))
        {
            house.setPhone(phone);
        }
        System.out.println("地址("+house.getAddress()+"):");
        System.out.println("不需要修改请按回车");
        String address=Utility.readString(16, "");
        if(!"".equals(address))
        {
            house.setAddress(address);
        }
        System.out.println("租金("+house.getRent()+"):");
        System.out.println("不需要修改请按回车");
        int rent = Utility.readInt(-1);
        if(rent!=-1)
        {
            house.setRent(rent);
        }
        System.out.println("状态("+house.getState()+"):");
        System.out.println("不需要修改请按回车");
        String state = Utility.readString(3, "");
        if(!"".equals(state))
        {
            house.setState(state);
        }
        System.out.println("修改房屋成功");
    }
//findHouse()
    public void findHouse(){
        System.out.println("------------查找房源----------------");
        System.out.println("请输入待查找的房屋编号");
        int findId=Utility.readInt();
        House house = houseService.findById(findId);
        if(house!=null)
        {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(house);
        }
        else {
            System.out.println("查找房屋id不存在");
        }
    }
//exit退出
    public  void exitHouse(){
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }

//删除delHouse()
    public void delHouse(){
        System.out.println("------------删除房源----------------");
        System.out.println("请输入待删除的房屋编号(-1退出)");
        int delId=Utility.readInt();
        if(delId==-1)
        {
            System.out.println("放弃删除房源信息");
            return;
        }
        char choice=Utility.readConfirmSelection();
        if(choice=='Y'){
            if(houseService.del(delId))
            {
                System.out.println("删除房源信息成功");
            }
            else
            {
                System.out.println("房屋标号不存在");
            }
        }
        else {
            System.out.println("放弃删除房源信息");
        }
    }


   //显示房屋列表
    public void ListHosues(){
        System.out.println("------------房屋列表----------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses=houseService.list();//得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if(houses[i]==null) {
                break;
            }
            System.out.println(houses[i]);
        }
    }

    //添加房屋信息;id系统分配，自增长
    public void addHosue(){
        System.out.println("------------添加房屋----------------");
        System.out.println("姓名");
        String name=Utility.readString(8);
        System.out.println("电话");
        String phone=Utility.readString(11);
        System.out.println("地址");
        String address=Utility.readString(16);
        System.out.println("月租");
        int rent=Utility.readInt();
        System.out.println("状态");
        String state=Utility.readString(3);
        House newHouse=new House(0, name, phone, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("添加房屋成功");
        }
        else {
            System.out.println("添加房屋失败");
        }
    }

    public void mainMenu(){
        do{
            System.out.println("------------房屋出租系统----------------");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删除房屋信息");
            System.out.println("\t\t4 修改房屋信息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退       出");
            System.out.println("请输入你的选择（1-6）");
            key= Utility.readChar();
            switch (key){
                case '1':
                    addHosue();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    ListHosues();
                    break;
                case '6':
                    exitHouse();
                    break;
            }
        }
        while (loop);
    }
}
