import java.util.concurrent.atomic.AtomicInteger;

class Counter6{
    AtomicInteger count = new AtomicInteger(0);

    void increment(){
        count.incrementAndGet();
    }
}
public class MultiThreading_Telusko58 {
    static void main(String[] args) {
        Counter6 counter = new Counter6();

        Thread t1 = new Thread(()->{
            for (int i = 1; i <=10000 ; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <=10000 ; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        System.out.println(counter.count);
    }
}
