package thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:08 18-9-27
 * @Modified: null
 */
public class TryLockDemo {
    private static List<Integer> mylist = new ArrayList<>();
    private Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        final TryLockDemo tryLockDemo = new TryLockDemo();

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                tryLockDemo.insert(Thread.currentThread());
            }).start();
        }


    }

    private void insert(Thread thread){

        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
                for (int i = 0; i < 5; i++) {
                    mylist.add(i);
                }
            } catch (Exception e){
                System.out.println("异常");
            }finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }

}

