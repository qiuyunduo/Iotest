package thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午8:21 18-9-27
 * @Modified: null
 */
public class ReentrantLockDemo {
    private static List<Integer> mylist = new ArrayList<>();
    private Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        final ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        new Thread(()->{
            reentrantLockDemo.insert(Thread.currentThread());
        }).start();

        new Thread(()->{
            reentrantLockDemo.insert(Thread.currentThread());
        }).start();

    }

    private void insert(Thread thread){
        lock.lock();

        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                mylist.add(i);
            }
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
