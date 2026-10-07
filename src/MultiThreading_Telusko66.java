import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreading_Telusko66 {
    static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("Welcome to Website.");
        },0,2, TimeUnit.SECONDS);

        scheduler.shutdown();
    }

}
