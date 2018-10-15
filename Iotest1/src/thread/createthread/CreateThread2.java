package thread.createthread;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午8:44 18-9-27
 * @Modified: null
 */
public class CreateThread2{
    public static void main(String[] args) {
        Thread thread2 = new Thread2("thread2");
        thread2.start();
    }

}

class Thread2 extends Thread{
    public Thread2(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+"正在执行。。。");
    }
}
