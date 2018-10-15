package thread;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午11:36 18-9-17
 * @Modified: null
 */
public class WaitThread {
    public static void main(String[] args) throws InterruptedException {
        Thread sumthread = new SumThread();
        sumthread.start();

        synchronized (sumthread){
            System.out.println("等待对象sumthread计算完成");
            sumthread.wait();
            System.out.println("sumthread对象计算的总和："+SumThread.total);
        }
    }
}

class SumThread extends Thread{
    public static int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            //（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
            notify();
            System.out.println("计算完成");
        }
    }

}
