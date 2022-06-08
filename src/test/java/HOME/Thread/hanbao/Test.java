package HOME.Thread.hanbao;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Box box = new Box();
        Seller seller = new Seller(box);
        seller.setName("秦始皇");
        Customer customer1 = new Customer(2,box);
        Customer customer2 = new Customer(3,box);
        customer1.setName("老子");
        customer2.setName("孙子");
        seller.start();
        box.start();
        customer1.start();
        customer2.start();
        //监视器线程
        new Thread(()->{
            while (true) {
                long end = System.currentTimeMillis();
                if(end - start >= 20 * 1000){
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("当前烤箱汉堡数:"+box.getQueue().size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
