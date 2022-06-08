package Thread;

public class Dog extends Thread {
    @Override
    public void run() {
        synchronized (Box.class){
            if(Box.meat>=1){
                try {
                    Thread.sleep(1000);
                    Box.meat--;
                    System.out.println(this.getName()+"吃了肉还剩"+Box.meat);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

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
class Box{
    public static int meat=1;
}