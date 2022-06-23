package OopTest;
//基本数据类型的传参机制
//基本数据类型，传递的是值（值拷贝），形参的任何改变不影响实参！！！
/*基本数据类型只有8种，可按照如下分类
        ①整数类型：long、int、short、byte
        ②浮点类型：float、double
        ③字符类型：char
        ④布尔类型：boolean*/
//swap和main是两个独立的栈空间，swap中的ab发生交换（形参），不影响main中的ab（实参）。
public class BasicDateType {
    public static void main(String[] args) {
        String a="10",b="20";
        basicType basicType=new basicType();
        basicType.swap(a, b);
        System.out.println("a="+a+"b="+b);
    }
}
class basicType{
    public void swap(String a,String b){
        System.out.println("交换前"+"a="+a+"b="+b);
        String temp=a;
        a=b;
        b=temp;
        System.out.println("交换后"+"a="+a+"b="+b);
    }
}
