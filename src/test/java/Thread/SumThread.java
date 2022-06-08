package Thread;

public class SumThread extends Thread {
    private int n;
    private int m;
    private int sum;

    public SumThread(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum=0;
        for (int i = n; i <=m; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws InterruptedException {
        final SumThread sumThread1 = new SumThread(1, 100);
        final SumThread sumThread2 = new SumThread(101, 200);
        sumThread1.start();
        sumThread2.start();
        sumThread1.join();
        sumThread2.join();
        int sum1=sumThread1.getSum();
        int sum2=sumThread2.getSum();
        System.out.println(sum1+sum2);
    }
}



//public class SumThread {
//    public static void main(String[] args) {
//        final Sum1 sum1 = new Sum1();
//        final Sum2 sum2 = new Sum2();
//        final Thread thread1 = new Thread(sum1);
//        final Thread thread2 = new Thread(sum2);
//        thread1.start();
//        thread2.start();
//    }
//}
//class  Sum1 implements Runnable{
//
//    @Override
//    public void run() {
//        int sum=0;
//        for (int i = 1; i <=100; i++) {
//            sum+=i;
//            System.out.println(Thread.currentThread()+"线程1次数"+i+"和"+sum);
//        }
//    }
//}
//
//class  Sum2 implements Runnable{
//
//    @Override
//    public void run() {
//        int sum=0;
//        for (int i = 101; i <=200; i++) {
//            sum+=i;
//            System.out.println(Thread.currentThread()+"线程2次数"+(i-100)+"和"+sum);
//        }
//    }
//}


//public class SumThread {
//
//    public static void main(String[] args) {
//
//        new Thread(()-> {
//            int sum1 = 0;
//            for (int i = 1; i <= 100; i++) {
//                sum1 += i;
//                System.out.println(Thread.currentThread() + "线程1次数" + i + "和" + sum1);
//            }
//        }
//        ).start();
//        new Thread(()-> {
//            int sum2 = 0;
//            for (int i = 101; i <= 200; i++) {
//                sum2 += i;
//                System.out.println(Thread.currentThread() + "线程1次数" + i + "和" + sum2);
//            }
//        }
//        ).start();
//
//
//    }
//}
