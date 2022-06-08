package HOME.Thread.hanbao;

import java.util.concurrent.LinkedBlockingQueue;

public class Box extends Thread{

    private LinkedBlockingQueue<Hanbao> queue = new LinkedBlockingQueue<>();

    public LinkedBlockingQueue<Hanbao> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<Hanbao> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5000);
                queue.forEach(hanbao -> hanbao.setShu(true));
                System.out.println("烤箱烤熟了汉堡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
