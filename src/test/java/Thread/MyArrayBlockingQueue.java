package Thread;

public class MyArrayBlockingQueue {
    private Object[]arr=new Object[5];
    private int putIndex;
    private int takeIndex;
    private int size;

    public synchronized void put(Object obj) throws InterruptedException {
        while (size==arr.length){
            System.out.println("队列满了，生产者等待");
            this.wait();//当前线程等待，同时释放同步锁
        }
        arr[putIndex++]=obj;
        if(putIndex==arr.length){
            putIndex=0;
        }
        size++;
        System.out.println("生产者生产了一个元素");
        this.notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        while (size==0){
            System.out.println("队列空了，消费者等待");
            this.wait();
        }
        size--;
        Object obj=arr[takeIndex];
        arr[takeIndex++]=null;
        if(takeIndex==arr.length){
            takeIndex=0;
        }
        this.notifyAll();//唤醒全部处于等待的线程
        System.out.println("消费者消费了一个元素");
        return obj;
    }

    public static void main(String[] args) {
        final MyArrayBlockingQueue queue = new MyArrayBlockingQueue();
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
        }
        ).start();
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
        }
        ).start();


    }

}
