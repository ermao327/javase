package HouseRentSys.Service;

import HouseRentSys.Domain.House;

/*
定义House[]，保存House对象
响应HouseView的调用
完成crud
*/
public class HouseService {
    private House[] houses;
    private int houseNums=1;
    private int idcounter=1;
    public HouseService(int size){
        houses=new House[size];//创建HouseService对象时，指定数组大小
        houses[0]=new House(1, "张三", "110", "警察局", 9000, "未出租");
    }

    //list方法。返回houses
    public House[] list(){
        return houses;
    }

    //add方法，add(House newHouse)
    public boolean add(House newHosue){
        if(houseNums==houses.length)
        {
            System.out.println("数组已满，不能再添加了");
            return false;
        }
        houses[houseNums++]=newHosue;//newhouse加入数组
        newHosue.setId(++idcounter);//id自增长
        return true;
    }

    //del方法
    public boolean del(int delId){
        //应当先找出要删除的房屋信息对应的下标
        //下表和房屋编号不是一回事
        int index=-1;
        for (int i = 0; i < houseNums; i++) {
            if(delId==houses[i].getId())
            {
                //要删除的房屋id，是数组下表为i的元素
                index = i;//记录i
            }
        }
        if(index==-1)
        {
            //说明delid在数组中不存在
            return false;
        }
        for (int i = index; i < houseNums-1; i++) {
            houses[i]=houses[i+1];
        }
        //将当前存在的房屋信息的最后一个设置为null
        houses[--houseNums]=null;
        return true;
    }
    //findId方法 ，放回House对象或者null
    public House findById(int findId){
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
}
