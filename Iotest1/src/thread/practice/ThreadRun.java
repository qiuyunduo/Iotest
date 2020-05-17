package thread.practice;

public class ThreadRun extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {

        }
        System.out.print("run ");
    }

    public static void main(String[] args) {
        ThreadRun run = new ThreadRun();
        run.run();
        System.out.println("main ");
    }
}
