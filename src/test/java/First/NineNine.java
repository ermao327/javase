package First;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NineNine {
    public static void main(String[] args) {

        /*--------------原始输出九九表---------*/
//        for(int i=1;i<=9;i++) {
//            for(int j=1;j<=9;j++) {
//                System.out.print(i+"×"+j+"="+i*j+"\t");
//            }
//            System.out.println();
//        }

/*-------------左下角三角形输出（1-1 1-2）----------------*/
//        for(int i=1;i<=9;i++) {
//            for(int j=1;j<=i;j++) {
//                System.out.print(j+"×"+i+"="+i*j+"\t");
//            }
//            System.out.println();
//        }
/*-----------------右下角三角形输出----------------------*/
//        for(int i=9;i>0;i--) {
//            for(int j=1;j<=9;j++) {
//                if(j<i)
//            System.out.printf("       ");//7个空格，我也不知道
//        else
//                    System.out.printf("%d*%d=%2d ",i,j,i*j);//不要问为什么，我也不知道，反正这样写就对齐了
//            }
//            System.out.println();
//        }

/*--------------左上角三角形输出1-1 1-2*/

//        for(int i=9;i>0;i--) {
//            for(int j=1,k=10-i;j<=i;j++,k++) {
//                System.out.print(j+"×"+k+"="+k*j+"\t");
//            }
//            System.out.println();
//        }

/*--------------左上角三角形输出（1-9 2-9）---------*/
//        for(int i=1;i<10;i++) {
//            for(int j=9;j>=i;j--) {
//                System.out.print(i+"×"+j+"="+i*j+"\t");
//            }
//            System.out.println();
//        }

        /*-------------右上角---------------------------*/
//for(int i=1;i<=9;i++)
//{
//    for (int j = 1; j <=9 ; j++) {
//        if(j<i)
//            System.out.printf("       ");//7个空格
//        else
//            System.out.printf("%d*%d=%2d ",i,j,i*j);
//    }
//    System.out.println();
//}
/*-------3位以内的水仙花数；每一位数的次方幂之和等于它本身--------------*/
//        for(int i=100;i<1000;i++)
//        {
//            int m = i %10;//个位
//            int n = i/10%10;//十位
//            int p = i/100;//百位
//            if(m*m*m+n*n*n+p*p*p==i)
//            {
//                System.out.println(i);
//            }
//        }

/*----------随即猜数--------------*/
//        final double d = Math.random();
//        final int i = (int)(d*100); //生成1-100随机数
//        System.out.println(i);
//        while (true)
//        {
//            Scanner n =new Scanner(System.in);
//            int j=n.nextInt();//输入猜想数
//            if(j<i)
//            {
//                System.out.println("猜小了,请继续猜");
//            }
//            else if (j>i)
//            {
//                System.out.println("猜大了");
//            }
//            else
//                System.out.println("猜对了");
//        }

/*----------两个数的最大公约数------------*/
//最大公约数定义：把能够整除某一个数的数，叫做这个数的约数。
// 几个数所公有的约数叫这几个数的公约数。公约数中最大的一个叫做这几个数的最大公约数。
// 例如：27和15,，27 的约数有1,27，3,9；15的约数为：1,15，3,5。而27 和15 的公约数为1,3.则最大公约数为3。
/*--辗转相除法--*/
//先将两个整数a与b进行相除，如果余数为0（a%b==0），则b为两数的最大公约数；
// 如果不等于0，则将b赋值给a，将余数赋值给b，在对a与b进行相除，直到余数为0时终止（a%b==0），则b为最大公约数。
//        Scanner n =new Scanner(System.in);
//        int a=n.nextInt();
//        Scanner m =new Scanner(System.in);
//        int b=n.nextInt();
//        int i=a%b;
//        while (i!=0)
//        {
//            a=b;b=i;i=a%b;
//        }
//        System.out.println(b);
/*--列举法--*/
//用循环进行列举依次排查，从1开始到它本身（这里的循环结束的表示可以在两个数之间随意选择，只要可以取到它本身就可以），
// 因为我们是从小到大依次排列过来的所以每次只要将可以整除的数字赋值给一个变量就可以，保证变量每次都会更新为最大值。
//        Scanner n =new Scanner(System.in);
//        int a=n.nextInt();
//        Scanner m =new Scanner(System.in);
//        int b=n.nextInt();
//        int j=0;
//        for (int i = 1;i <= b;i++)
//                {
//                     if (a % i == 0 && b % i == 0)
//                         {
//                           j = i;//将公约数赋值给变量
//                      }
//                 }
//        System.out.println(j);

/*判断一个数是否为质数(素数)*/
//只能被1和自身整除的数
//        Scanner n =new Scanner(System.in);
//        int a=n.nextInt();
//        int count=0; //boolean num=true;
//        for(int i=2;i<a;i++) {
//            if (a % i == 0) {
//                count++;   //num=false;break;
//            }
//        }
//        if(count==0) //if(num)
//        {
//            System.out.println("是质数");
//        }
//        else
//        {
//            System.out.println("不是质数");
//        }

/*--------找到200以上的最小的质数--------*/
//        for(int j=200;;j++)
//        {
//            boolean num=true;
//            for(int i=2;i<j;i++)
//            {
//                if(j%i==0)
//                {num=false;break;}
//            }
//            if(num)
//            {
//                System.out.println(j);
//                break;
//            }
//
//        }

/*----1-----*/
//int i=17;
//if(i%2==0)
//    System.out.println(i+"是偶数");
//else
//    System.out.println(i+"不是偶数");

/*---2---*/
//int i=17;
//switch (i)
//{
//    case 1:
//        System.out.println("i是1");break;
//    case 2:
//        System.out.println("i是2");break;
//    case 17:
//        System.out.println("i是17");break;
//    default:
//        System.out.println("不是以上");
//}





    }
}
