package smallchangemoney.OOP;
//用面向对象的方式完成零钱通项目
//相当于ui，只管显示，完成方法调用SmallChangeSys中的方法
public class IndexMenuoop {
    public static void main(String[] args) {
//        SmallChangeSys smallChangeSys=new SmallChangeSys();
//        smallChangeSys.mainmenu();
        new SmallChangeSys().mainmenu();//一步实现上面两部代码
    }

}
