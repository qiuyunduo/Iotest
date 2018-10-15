package thread.countThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午10:26 18-9-26
 * @Modified: null
 */
public class CountDownThread {
    private static CountDownLatch countDownLatch = null;
    private static final int THREAD_NUMBER = 3;

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(THREAD_NUMBER);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_NUMBER);
        fixedThreadPool.execute(new ConsumeRunnable("One"));
        fixedThreadPool.execute(new ConsumeRunnable("Two"));
        fixedThreadPool.execute(new ConsumeRunnable("Three"));

        System.out.println("等待３个子线程执行完毕。。。。。");

        try {
            countDownLatch.await();
            System.out.println("３个子线程执行完毕");
            System.out.println("开始执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ConsumeRunnable implements Runnable {

        private String TName;

        public ConsumeRunnable(String name){
            this.TName = name;
        }
        @Override
        public void run() {
            System.out.println("子线程"+TName+"正在运行");
            try {
                Thread.sleep(3000);
                System.out.println("子线程"+TName+"执行完毕");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
