import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading_Telusko70 {
    static void main(String[] args)throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i <=5 ; i++) {
            executor.submit(()->{
                System.out.println("Task executed by " + Thread.currentThread());
            });
        }
        Thread.sleep(3000);
        
        executor.shutdown();
    }
}
