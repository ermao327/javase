package Thread.concurrent;

import java.util.concurrent.ExecutionException;

/**
 * 洗脸(5)
 * 刷牙(5)
 * 烧水(5)
 * 煮鸡蛋(5)
 * 吃鸡蛋(5)
 * (烧热水、刷牙、煮鸡蛋)->洗脸->吃鸡蛋
 * 用传统的多线程来设计整个流程，最后打印一共花了多少秒
 */
public class 起床 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long stime = System.currentTimeMillis();
//        final Thread th1 = new Thread(() -> {
//            try {
//                烧水();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        final Thread th2 = new Thread(() -> {
//            try {
//                煮鸡蛋();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        final Thread th3 = new Thread(() -> {
//            try {
//                刷牙();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        th1.start();
//        th2.start();
//        th3.start();
//        th1.join();
//        th2.join();
//        th3.join();
//        洗脸();
//        吃鸡蛋();
//        long etime = System.currentTimeMillis();
//        System.out.println(etime-stime);

        //异步编程(使用这个玩意的时候，方法的sleep异常不能抛出，只能try/catch，不然报错)
//        CompletableFuture<Void> voidCompletableFuture =
//                CompletableFuture.allOf(
//                        CompletableFuture.runAsync(起床::烧水),
//                        CompletableFuture.runAsync(起床::刷牙),
//                        CompletableFuture.runAsync(起床::煮鸡蛋)
//                        ).thenRun(起床::洗脸).thenRun(起床::吃鸡蛋);
//                voidCompletableFuture.get();
//                long etime = System.currentTimeMillis();
//                System.out.println(etime-stime);


//        //异步编程
//        CompletableFuture<Void> voidCompletableFuture =
//                CompletableFuture.allOf(
//                        CompletableFuture.runAsync(起床::烧水),
//                        CompletableFuture.runAsync(起床::刷牙),
//                        CompletableFuture.runAsync(起床::煮鸡蛋)
//                ).thenComposeAsync(v ->  CompletableFuture.allOf(
//                        CompletableFuture.runAsync(起床::洗脸),
//                        CompletableFuture.runAsync(起床::吃鸡蛋)
//                ));

        }

    public static void 洗脸() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("洗脸");
    }
    public static void 刷牙()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("刷牙");
    }
    public static void 烧水()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("烧水");
    }
    public static void 煮鸡蛋()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("煮鸡蛋");
    }
    public static void 吃鸡蛋() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("吃鸡蛋");
    }
}
