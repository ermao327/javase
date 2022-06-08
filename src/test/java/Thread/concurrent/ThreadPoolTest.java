package Thread.concurrent;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ArrayBlockingQueue queue = new ArrayBlockingQueue<>(5);//任务队列(数组实现的有界阻塞队列)
        final ThreadPoolExecutor poll = new ThreadPoolExecutor(//JDK线程池
                5,//核心线程数
                10,//最大线程数=核心+非核心
                1,//非核心线程的存活时间
                TimeUnit.SECONDS,//时间单位
                queue,
                new ThreadFactory() {//线程工厂(可以改成lambda表达式)
                    @Override
                    public Thread newThread(Runnable r) {
                        final Thread th = new Thread(r);
                        th.setName("aaa");
                        return th;
                    }
                },
                new RejectedExecutionHandler() {//拒绝策略(可以改成lambda表达式)
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("拒绝任务");

                    }
                }
        );//任务队列
        for (int i = 0; i < 15; i++) {
            //Runnable
            poll.execute(()->{
                System.out.println(Thread.currentThread()+"_"+queue);
            });
        }
        Thread.sleep(1000);
        System.out.println(poll.getPoolSize());
        //Callable
        Future<Integer> submit = poll.submit(() -> 1);
        Integer integer = submit.get();
        System.out.println(integer);
        poll.shutdown();//关闭线程池


//        //快捷线程池
//        //缓存线程池，线程会爆炸
//        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        cachedThreadPool.execute(()->{
//            System.out.println(Thread.currentThread()+"-"+queue);
//        });



    }
}
