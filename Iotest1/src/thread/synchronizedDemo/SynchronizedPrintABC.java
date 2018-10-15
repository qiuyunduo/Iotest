package thread.synchronizedDemo;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午5:09 18-9-28
 * @Modified: null
 */
public class SynchronizedPrintABC {
    private final String STR_ONE = "A";
    private final String STR_TWO = "B";
    private final String STR_THREE = "C";

    public static void main(String[] args) {
        SynchronizedPrintABC printABC = new SynchronizedPrintABC();

        new Thread(()->{
            printABC.PrintA();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            printABC.PrintB();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            printABC.PrintC();
        }).start();
    }

    public void PrintA(){
        synchronized (STR_THREE) {
            int i = 10;
            while (i-- > 0) {
                synchronized (STR_ONE){
                    System.out.println(Thread.currentThread().getName() + "打印---" + STR_ONE + "---");
                    STR_ONE.notify();
                }

                try {
                    STR_THREE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (STR_ONE){
                STR_ONE.notify();
            }
        }
    }

    public void PrintB(){
        synchronized (STR_ONE) {
            int i = 10;
            while (i-- > 0) {
                synchronized (STR_TWO) {
                    System.out.println(Thread.currentThread().getName() + "打印---" + STR_TWO + "---");
                    STR_TWO.notify();
                }
                try {
                    STR_ONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (STR_TWO){
                STR_TWO.notify();
            }
        }
    }

    public void PrintC(){
        synchronized (STR_TWO) {
            int i = 10;
            while (i-- > 0) {
                synchronized (STR_THREE) {
                    System.out.println(Thread.currentThread().getName() + "打印---" + STR_THREE + "---");
                    STR_THREE.notify();
                }
                try {
                    STR_TWO.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (STR_THREE){
                STR_THREE.notify();
            }
        }
    }


}
