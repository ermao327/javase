package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有两个线程
 * 1.分别同时产生10个随机数[1-100]
 * 2.分别找到最大的数
 * 3.计算这两个最大的数的差
 * 建议用Callable
 */
public class Test01 implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<Integer> callable = ()->{
//            int max = 0;
//            for (int i = 0; i < 10; i++) {
//                int random = (int)(Math.random()*100 + 1);
//                if(random > max){
//                    max = random;
//                }
//            }
//            return max;
//        };

        final Test01 test01 = new Test01();
        FutureTask<Integer> futureTask1 = new FutureTask<>(test01);
        FutureTask<Integer> futureTask2 = new FutureTask<>(test01);

//        FutureTask<Integer> futureTask1 = new FutureTask<>(callable);
//        FutureTask<Integer> futureTask2 = new FutureTask<>(callable);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        int num1 = futureTask1.get();
        int num2 = futureTask2.get();
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1-num2);

    }

    @Override
    public Object call() throws Exception {
            int max = 0;
            for (int i = 0; i < 10; i++) {
                int random = (int)(Math.random()*100 + 1);
                if(random > max){
                    max = random;
                }
            }
            return max;
    }
}