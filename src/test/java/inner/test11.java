package inner;

import java.security.PublicKey;

public class test11 {
    public static void main(String[] args) {
        final CellPhone cellPhone = new CellPhone();
        cellPhone.clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了");
            }
        });
        cellPhone.clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了");
            }
        });

    }

}
interface Bell{//闹钟接口
    void ring();
}
class CellPhone{//手机类，具有闹钟功能
    public void clock(Bell bell){//形参是Bell接口类型
        bell.ring();
    }
}