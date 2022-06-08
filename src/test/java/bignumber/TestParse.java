package bignumber;
public class TestParse {


    public static void main(String[] args) {
        //将某个字符串解析成int型
        int i2 = Integer.parseInt("123");
        float v = Float.parseFloat("12.3f");
        double v1 = Double.parseDouble("12.3");
        //将10进制转成2进制的表现形式
        System.out.println(Integer.toBinaryString(100));
        //8进制
        System.out.println(Integer.toOctalString(100));
        //16进制
        System.out.println(Integer.toHexString(100));
        System.out.println("int型的最大值:"+Integer.MAX_VALUE);
        System.out.println("int型的最小值:"+Integer.MIN_VALUE);

    }
}
