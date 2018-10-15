package thread.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午4:15 18-9-28
 * @Modified: null
 */
public class ConditionDemo1 {
    private String str = "A";
    private ReentrantLock lock = new ReentrantLock();
    Condition _printa = lock.newCondition();
    Condition _printb = lock.newCondition();
    Condition _printc = lock.newCondition();
    public static void main(String[] args) {
        ConditionDemo1 demo1 = new ConditionDemo1();
        new Thread(){
            public void run(){
                for(int i = 0; i < 10; i++) {
                    demo1.printC();
                }
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(){
            public void run(){
                for(int i = 0; i < 10; i++) {
                    demo1.printB();
                }
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(){
            public void run(){
                for(int i = 0; i < 10; i++) {
                    demo1.printA();
                }
            }
        }.start();

    }

    public void printA(){
        lock.lock();
        try{
            if(str != "A")
                _printa.await();
            System.out.println(Thread.currentThread().getName()+"---打印A---");
            str = "B";
            _printb.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try{
            if(str != "B")
                _printb.await();
            System.out.println(Thread.currentThread().getName()+"---打印B---");
            str = "C";

            _printc.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try{
            if(str != "C")
                _printc.await();
            System.out.println(Thread.currentThread().getName()+"---打印C---");
            System.out.println();
            str = "A";
            _printa.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
