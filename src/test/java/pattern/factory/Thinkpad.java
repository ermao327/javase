package pattern.factory;

public class Thinkpad implements Notebook{
    @Override
    public void compute() {
        System.out.println("Thinkpad正在计算");
    }
}
