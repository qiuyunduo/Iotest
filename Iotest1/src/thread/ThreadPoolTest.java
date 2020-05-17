package thread;

import java.util.concurrent.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午12:00 18-9-17
 * @Modified: null
 */
public class ThreadPoolTest {
    private static int POOL_NUM = 30;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,5, TimeUnit.MINUTES,arrayBlockingQueue);


        for (int i = 0; i < POOL_NUM; i++){
            RunAbleThread runAbleThread = new RunAbleThread();
//            executorService.execute(runAbleThread);
            threadPoolExecutor.execute(runAbleThread);
        }

        executorService.shutdown();
    }
}

class RunAbleThread implements Runnable{

    @Override
    public void run() {
        System.out.println("通过线程池创建的线程："+Thread.currentThread().getName()+"...");
    }
}
