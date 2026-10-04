import java.util.concurrent.*;

public class MultiThreading_Telusko54 {
    static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () ->{
            for (int i = 0; i <=10 ; i++) {
                System.out.println("Working..." + i);
                Thread.sleep(1000);
            }
            return 100;
        };

        Future<Integer> result = service.submit(task);

        Thread.sleep(3000);

        result.cancel(true);

        System.out.println("Cancelled: " + result.isCancelled());
        System.out.println("Done: " + result.isDone());

        service.shutdown();
    }
}
