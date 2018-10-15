package thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:57 18-9-27
 * @Modified: null
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        final ReentrantReadWriteLockDemo rrwl = new ReentrantReadWriteLockDemo();


        for(int i = 0; i < 20; i++){
            new Thread(){
                public void run(){
                    rrwl.readSome(Thread.currentThread());
                }
            }.start();
        }

        for(int i = 0; i < 20; i++){
            new Thread(){
                public void run(){
                    rrwl.writeSome(Thread.currentThread());
                }
            }.start();
        }
    }

    private void readSome(Thread thread){
//        System.out.println(writeLock.isFair());   //判断该锁是否为公平锁
        System.out.println(thread.getName()+"获得了读锁");
        writeLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }

            System.out.println(thread.getName() + "读操作完毕");
        }finally {
            System.out.println(thread.getName()+"释放了读锁");
            writeLock.readLock().unlock();
        }
    }

    private void writeSome(Thread thread){
        System.out.println(thread.getName()+"获得了写锁");
        writeLock.writeLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行写操作");
            }

            System.out.println(thread.getName() + "写操作完毕");
        }finally {
            System.out.println(thread.getName()+"释放了写锁");
            writeLock.writeLock().unlock();
        }
    }
}
