package blockqueen.arraryblock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:49 18-9-17
 * @Modified: null
 */
public class ArraryBlockQueenTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Productor productor = new Productor(queue);
        Customer customer = new Customer(queue);

        new Thread(productor).start();
        new Thread(customer).start();

        Thread.sleep(4000);
    }
}
