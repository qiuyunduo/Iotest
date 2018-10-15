package thread.createthread;

import java.util.concurrent.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午8:50 18-9-27
 * @Modified: null
 */
public class CreateThread4 {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue =
                             new LinkedBlockingQueue<Runnable>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,queue);

        for(int i = 0; i < 10; i++){
            Runnable runnable = new Thread4();
            executorService.execute(runnable);
        }

        poolExecutor.execute(new Thread(new Thread4(),"Thread"));
        executorService.shutdown();

    }
}

class Thread4 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"正在运行。。。");
    }
}

