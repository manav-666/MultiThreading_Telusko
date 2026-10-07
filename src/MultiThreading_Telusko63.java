import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreading_Telusko63 {
    static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

//        try{
//            executor.execute(()->{
//                int x = 10/0;
//            });
//        } catch (Exception e) {
//            System.out.println("Catched Execute Exception.");
//        }



        Future<Integer> f1 = executor.submit(()->{
            return (10/0);
        });

        try{
            System.out.println(f1.get());

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Catched Submit Exception.");
        }

        executor.shutdown();
    }
}
