package Ex;

public class Print {
    static int i = 1;

    public static void main(String[] args) {
        new Thread(()->{
            for (;;) {
                synchronized (Print.class) {
                    if(i % 2 == 0){
                        try {
                            Print.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i > 100){
                        break;
                    }
                    System.out.println(Thread.currentThread() + "-" + i);
                    Print.class.notifyAll();
                    i++;
                }
            }
        }).start();

        new Thread(()->{
            for (;;) {
                synchronized (Print.class) {
                    if(i % 2 == 1){
                        try {
                            Print.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i > 100){
                        break;
                    }
                    System.out.println(Thread.currentThread() + "-" + i);
                    Print.class.notifyAll();
                    i++;
                }
            }
        }).start();
    }
}
