package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1.call方法可以有返回值
 * 2.方法可以抛出非运行时异常
 * 3.一般结合FutrueTask来使用
 *
 */
public class MyCallable implements Callable<Integer> {

    private int n;

    private int m;

    public MyCallable(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = n; i <= m; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable(1,100);
        MyCallable myCallable2 = new MyCallable(101,200);
        FutureTask<Integer> futureTask1 = new FutureTask<>(myCallable1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myCallable2);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.start();
        thread2.start();
        int sum1 = futureTask1.get();//会自己等待
        int sum2 = futureTask2.get();
        System.out.println("总和:"+(sum1+sum2));

    }
}
