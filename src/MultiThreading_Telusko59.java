import java.util.concurrent.atomic.AtomicInteger;

class Counter7{
    AtomicInteger count = new AtomicInteger(0);

    void increment(){

        System.out.println(count.get());;
        //count.set(5);
        System.out.println(count.incrementAndGet());
        System.out.println(count.getAndIncrement());
        System.out.println(count.decrementAndGet());
        System.out.println(count.getAndDecrement());
        System.out.println(count.getAndAdd(1));
        System.out.println(count.addAndGet(1));
    }
}
public class MultiThreading_Telusko59 {
    static void main(String[] args) {
        Counter7 counter7 = new Counter7();

        Thread t1 = new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                counter7.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                counter7.increment();
            }
        });

        t1.start();
        t2.start();

        try{
            Thread.sleep(2000);
        }catch(Exception _) {}

        System.out.println(counter7.count);
    }
}
