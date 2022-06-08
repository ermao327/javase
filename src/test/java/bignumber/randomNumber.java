package bignumber;

import java.util.Random;

public class randomNumber {


    public static void main(String[] args) {
        // 通过Math的random()函数返回一个double类型随机数，范围[0.0, 1.0)
        double d=Math.random();
        int i=(int)(d*10);//0-10
        int j=(int)(d*100);//0-100
        int k=(int)(10+d*(100-10+1));//10-100

        //[a,z]95-122
        char x=(char)(95+d*(122-95+1));
        char x1=(char)('a'+d*('z'-'a'+1));
        System.out.println(x1);


        //分布不均匀
        Random random = new Random();//默认构造方法
//        Random random = new Random(1000);//指定种子数字
        int i2 = random.nextInt(100);//0-100
    }
}
