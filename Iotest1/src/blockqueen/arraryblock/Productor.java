package blockqueen.arraryblock;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:52 18-9-17
 * @Modified: null
 */
public class Productor implements Runnable{
    protected BlockingQueue queue = null;

    public Productor(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
