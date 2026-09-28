class Counter2 {
    public int count = 0;

    synchronized void increment(){
        count++;
    }
}
public class MultiThreading_Telusko26 {
    static void main(String[] args)throws InterruptedException {
        Counter2 c1 = new Counter2();

        Thread t1 = new Thread(()-> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c1.count);
    }
}
