package thread;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午1:34 18-9-16
 * @Modified: null
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longlocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    ThreadLocal<String> stringlocal = new ThreadLocal<String>(){
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public void set(){
        longlocal.set(Thread.currentThread().getId());
        stringlocal.set(Thread.currentThread().getName());
    }

    public Long getLong(){
        return longlocal.get();
    }

    public String getString(){
        return stringlocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();

//        threadLocalTest.set();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

        Thread thread = new Thread(){
          public void run(){
              threadLocalTest.set();
              System.out.println(threadLocalTest.getLong());
              System.out.println(threadLocalTest.getString());
          }
        };

        thread.start();
        thread.join();

        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
    }
}
