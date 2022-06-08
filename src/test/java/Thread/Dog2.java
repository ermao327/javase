package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class Dog2 extends Thread {
    private Box2 box2;

    public Dog2(Box2 box2) {
        this.box2 = box2;
    }

    @Override
    public void run() {
        box2.eated();
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
class Box2{
    public  int meat=1;
    private ReentrantLock lock=new ReentrantLock();
    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public  void eated(){
        lock.lock();
        try {
            if(this.meat>=1){
                try {
                    Thread.sleep(1000);
                    this.meat--;
                    System.out.println(Thread.currentThread().getName()+"吃了肉还剩"+this.meat);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }


    }
}