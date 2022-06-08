package Thread;

public class MyTherad  extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this+"-"+i);
        }
    }



    public static void main(String[] args) {
        final MyTherad myTherad1 = new MyTherad();
        final MyTherad myTherad2 = new MyTherad();
        myTherad1.start();
        myTherad2.start();

        for (int i = 0; i < 10;i++) {
            System.out.println(Thread.currentThread()+"-"+i);
        }
    }

}
