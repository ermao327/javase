package Thread;

public class Dog1 extends Thread {
    private Box1 box1;

    public Dog1(Box1 box1) {
        this.box1 = box1;
    }

    @Override
    public void run() {
        box1.eated();
    }


    public static void main(String[] args) {
        final Dog dog1 = new Dog();
        dog1.setName("二哈");

        final Dog dog2 = new Dog();
        dog2.setName("二r");
        dog1.start();
        dog2.start();

    }
}
class Box1{
    public  int meat=1;
    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public synchronized void eated(){
            if(this.meat>=1){
                try {
                    Thread.sleep(1000);
                    this.meat--;
                    System.out.println(Thread.currentThread().getName()+"吃了肉还剩"+this.meat);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}