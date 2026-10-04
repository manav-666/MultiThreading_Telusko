import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreading_Telusko55 {
    static void main(String[] args)throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Callable<String> task = () ->{
            for (int i = 0; i <=10 ; i++) {
                System.out.println("Downloading..." + i);
                Thread.sleep(1000);
            }
            return "Downloading Cancel";
        };

        Future<String> result = service.submit(task);

        Thread.sleep(3000);

        result.cancel(true);

        System.out.println("Cancelled: " + result.isCancelled());
        System.out.println("Done: " + result.isDone());

        service.shutdown();
    }
}
