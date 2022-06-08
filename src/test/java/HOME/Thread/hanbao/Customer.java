package HOME.Thread.hanbao;

public class Customer extends Thread {

    private int time;

    private Box box;

    public Customer(int time, Box box) {
        this.time = time;
        this.box = box;
    }

    public Customer(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(time * 1000);
                //只看不取
                Hanbao peek = this.box.getQueue().peek();

                if (null != peek && peek.getShu()) {
                    //真正取出来
                    this.box.getQueue().take();
                    System.out.println(this.getName() + "取出了一个熟汉堡");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
