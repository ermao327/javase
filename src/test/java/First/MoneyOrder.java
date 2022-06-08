package First;

public class MoneyOrder {
    public static void main(String[] args) {
        char family = '张'; // 姓
        char name = '三'; // 名
        long num = 1234567890987654321L; // 银行账号
        double money = 10000; // 存款金额
        System.out.println("\t中国工商银行\n");
        System.out.println("---------------------------");
        System.out.println(" 日期：\t2021-03-10");
        System.out.println(" 户名：\t" + family + name);
        System.out.println(" 账号：\t" + num);
        System.out.println(" 币种：\tRMB");
        System.out.println(" 存款金额：\t" + money);
        System.out.println(" 存款序号：\t010");
        System.out.println(" 柜员号：\t12345");
        System.out.println("---------------------------");
    }
}
