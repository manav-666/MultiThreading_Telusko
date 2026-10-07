import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading_Telusko62 {
    static void main(String[] args) {
        //Executor Framework

        ExecutorService excutor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <=5 ; i++) {
            int taskId = i;
            excutor.execute(()->{
                System.out.println("Task " + taskId + " is performed by " + Thread.currentThread().getName());
            });
        }
        excutor.shutdown();
    }
}
