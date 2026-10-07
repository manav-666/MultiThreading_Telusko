import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreading_Telusko65 {
    static void main(String[] args) {
        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(2);

        schedular.schedule(()->{
            System.out.println("Task Executed!");
        },1, TimeUnit.SECONDS);

        schedular.shutdown();
    }
}
