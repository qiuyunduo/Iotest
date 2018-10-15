package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午10:55 18-9-26
 * @Modified: null
 */
public class CASDemo {
    static AtomicInteger cxsNum = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(; 100 > cxsNum.get();){
                if(!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"打印："+cxsNum.get());
                    flag = true;
                }
            }
        },"thread1");

        Thread t2 = new Thread(() -> {
            for(; 100 > cxsNum.get();){
                if(flag && cxsNum.incrementAndGet() % 2 != 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"打印："+cxsNum.get());
                    flag = false;
                }
            }
        },"thread2");

        t1.start();
        t2.start();
    }
}
