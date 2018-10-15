package thread.createthread;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午8:33 18-9-27
 * @Modified: null
 */
public class CreateThread1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread_1 = new Thread(new thread1(),"thread2");
                thread_1.start();
                try {
                    thread_1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sds");

            }
        },"thread1");

        thread.start();

        System.out.println("1");
    }
}

class thread1 implements Runnable{

    @Override
    public void run() {
        System.out.println("第一种创建线程方法");
    }
}
