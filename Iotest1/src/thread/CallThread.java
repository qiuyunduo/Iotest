package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午11:53 18-9-17
 * @Modified: null
 */
public class CallThread {
    public static void main(String[] args) {
        Callable callable = new Tickets();
        FutureTask task = new FutureTask(callable);

        Thread thread = new Thread(task);

        System.out.println(Thread.currentThread().getName());

        thread.start();
    }
}

class Tickets<Object> implements Callable<Object>{

    @Override
    public Object call() throws Exception {
        String a = "hello,world";
        System.out.println(Thread.currentThread().getName()+"-->我是通过callable接口通过FutureTask包装器来实现的线程");
        return null;
    }
}
