package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyArrayBlockingQueue2 {

    private Object[] arr = new Object[5];

    private int putIndex;

    private int takeIndex;

    private int size;

    private ReentrantLock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public  void put(Object obj) throws InterruptedException {
        lock.lock();
        try {
            //队列满了
            while (size == arr.length) {
                System.out.println("队列满了，生产者等待");
//            Thread.sleep(1000);
                notEmpty.await();
            }
            arr[putIndex++] = obj;
            if (putIndex == arr.length) {
                putIndex = 0;
            }
            size++;
            System.out.println("生产者生产了一个元素");
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public synchronized Object take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                System.out.println("队列空了，消费者等待");
                notFull.await();
            }
            size--;
            Object obj = arr[takeIndex];
            arr[takeIndex++] = null;
            if (takeIndex == arr.length) {
                takeIndex = 0;
            }
            notEmpty.signalAll();//唤醒全部处于等待的线程
            System.out.println("消费者消费了一个元素");
            return obj;
        }finally {
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        MyArrayBlockingQueue2 queue = new MyArrayBlockingQueue2();
        //生产者
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1500);
                    queue.put("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //消费者
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(500);
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
