package HOME.Thread.hanbao;

public class Seller extends Thread{

    private Box box;

    public Seller(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                box.getQueue().put(new Hanbao());
                System.out.println(this.getName()+"放了一个生汉堡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
