package thread;

import javax.swing.plaf.TableHeaderUI;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午11:12 18-9-17
 * @Modified: null
 */
public class JoinTest{
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread1("张三");

        thread1.start();


    }
}

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(this.getName() + ":" + i);
        }
    }
}

class MyThread1 extends Thread{
    protected MyThread myThread = new MyThread("小明");

    public MyThread1(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(this.getName() + ":" + i);
            if(i == 50){
                myThread.start();
//                try {
//                    myThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
