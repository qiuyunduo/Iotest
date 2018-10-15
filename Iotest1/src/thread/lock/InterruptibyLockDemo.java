package thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:21 18-9-27
 * @Modified: null
 */
public class InterruptibyLockDemo {
    private List<Integer> mylist = new ArrayList<>();
    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        InterruptibyLockDemo lockDemo = new InterruptibyLockDemo();

        MyThread1 thread1 = new MyThread1(lockDemo,"thread1");
        MyThread1 thread2 = new MyThread1(lockDemo,"thread2");

        thread1.start();
        thread1.interrupt();
        thread2.start();



    }

    public void insert(Thread thread) throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try{
            System.out.println(thread.getName()+"得到了锁");

            Thread.sleep(1000);

        }finally {
            System.out.println(Thread.currentThread().getName()+"进入了finally");
            reentrantLock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }
}

class MyThread1 extends Thread{
    private InterruptibyLockDemo lockDemo = null;

    public MyThread1(InterruptibyLockDemo lockDemo,String name){
        super(name);
        this.lockDemo = lockDemo;
    }

    public void run(){
        try {
            lockDemo.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}