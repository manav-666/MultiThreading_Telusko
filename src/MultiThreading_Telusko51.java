import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading_Telusko51 {
    static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(()->{
            System.out.println("Downloading File 1");
        });

        service.submit(()->{
           try{
               System.out.println("Downloading File 2");
               System.out.println("File Start Sleeping");
               Thread.sleep(5000);
               System.out.println("File End Sleeping");
           } catch (InterruptedException e) {}
        });

        service.submit(()->{
            System.out.println("Downloading File 3");
        });

        service.submit(()->{
            System.out.println("Downloading File 4");
        });

        service.shutdown();
    }
}
