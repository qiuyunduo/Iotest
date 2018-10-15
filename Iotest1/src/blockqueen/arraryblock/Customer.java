package blockqueen.arraryblock;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:52 18-9-17
 * @Modified: null
 */
public class Customer implements Runnable{
    protected BlockingQueue queue = null;

    public Customer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
