import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading_Telusko50 {
    static void main(String[] args)throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(()->{
            System.out.println("Task 1 is running");
        });

        service.submit(()->{
            System.out.println("Task 2 is running");
            try{
                System.out.println("Task 2 is sleeping");
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        });

        service.submit(()->{
            System.out.println("Task 3 is running");
        });

        service.shutdown();

    }
}
