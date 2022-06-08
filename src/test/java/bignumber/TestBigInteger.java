package bignumber;

import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("100001512111616");
        BigInteger bigInteger1 = new BigInteger("123");
        BigInteger add = bigInteger.add(bigInteger1);
        BigInteger multiply = bigInteger.multiply(bigInteger1);//乘积
        BigInteger subtract = bigInteger.subtract(bigInteger1);//差
        BigInteger divide = bigInteger.divide(bigInteger1);//商/除
        System.out.println(add);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
    }
}
