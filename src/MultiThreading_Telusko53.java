import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreading_Telusko53 {
    static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {
            Thread.sleep(3000);
            return 100;
        };

        Future<Integer> result = service.submit(task);

        System.out.println("Task Done? " + result.isDone());
        try{
            System.out.println("Result: " + result.get());
        }catch (Exception e){}

        System.out.println("Task Done? " + result.isDone());

        service.shutdown();
    }
}
