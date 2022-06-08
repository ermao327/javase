package bignumber;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.005");
        BigDecimal bigDecimal1 = new BigDecimal("0.05");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        double i=add.doubleValue();//将BigDecimal对象中的值转换成双精度数
        BigDecimal divide = bigDecimal.divide(bigDecimal1);
        double j=divide.doubleValue();
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(add);
        System.out.println(divide);
        System.out.println(i);
        System.out.println(j);

    }
}
