class Counter1 {
    public int count = 0;

    void increment(){
        count++;
    }
}
public class MultiThreading_Telusko23 {
    static void main(String[] args)throws InterruptedException {
        Counter1 c1 = new Counter1();

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

        Thread.sleep(2000);

        System.out.println(c1.count);
    }
}
