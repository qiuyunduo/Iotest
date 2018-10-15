package thread.synchronizedDemo;

import thread.lock.ReentrantReadWriteLockDemo;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:06 18-9-27
 * @Modified: null
 */
public class SynchronizedDemo1 {
    public static void main(String[] args) {
        final SynchronizedDemo1 demo1 = new SynchronizedDemo1();

        for(int i = 0; i < 5; i++){
            new Thread(()->{
                demo1.readSome(Thread.currentThread());
            }).start();
        }
    }

    private synchronized void readSome(Thread thread){
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start <= 1){
            System.out.println(thread.getName()+"正在进行读操作");
        }

        System.out.println(thread.getName()+"读操作完毕");
    }
}

