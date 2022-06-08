package pattern.proxy.stat;

public class Target implements TargetIn{
    @Override
    public void method() {
        System.out.println("目标类原有的方法");
    }

    public static void main(String[] args) {
        TargetIn target = new Target();
        target.method();
    }
}
