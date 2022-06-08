package Thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+"-"+i);
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);
        th1.start();
        th2.start();
    }
}
