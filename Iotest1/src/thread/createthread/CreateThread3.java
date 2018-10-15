package thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午8:48 18-9-27
 * @Modified: null
 */
public class CreateThread3 {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Thread3());
        Thread thread3 = new Thread(futureTask,"thread3");
        thread3.start();

    }
}

class Thread3 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"正在执行。。。。");
        return null;
    }
}
