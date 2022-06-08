package OopTest;

import java.util.Arrays;

//引用数据类型的传参机制
/*引用数据类型非常多，大致包括：
类、 接口类型、 数组类型、 枚举类型、 注解类型、 字符串型*/
//引用数据类型，传递的是地址（传递也是值，但这个值是地址），可以通过形参影响实参！！！
public class ReferenceDateType {
    public static void main(String[] args) {
        referenceType a=new referenceType();
        int[]arr={10,20,30};
        a.test100(arr);
        System.out.println(Arrays.toString(arr));

    }
}
class referenceType{
    public void test100(int[]arr){
        arr[0]=200;
    }
}