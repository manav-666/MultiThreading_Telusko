import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreading_Telusko64 {
    static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                                                          5,
                                                            10,
                                                            TimeUnit.SECONDS,
                                                            new ArrayBlockingQueue<>(2));

        for (int i = 1; i <=5 ; i++) {
            int taskId = i;

            executor.execute(() ->{
                System.out.println("Task " + taskId + " is performed by " + Thread.currentThread().getName());

                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            });
        }

        executor.shutdown();
    }
}
