class Counter5{
    int count = 0;

    void increment(){
        for (int i = 1; i <= 1000 ; i++) {
            synchronized(this){
                count++;
            }
        }
    }

    void display(){
        System.out.println("Count: " + count);
    }
}
public class MultiThreading_Telusko43 {
    static void main(String[] args) throws InterruptedException{
        Counter5 c1 = new Counter5();

        Thread t1 = new Thread(()->{
            c1.increment();
        });

        Thread t2 = new Thread(()-> c1.increment());
        Thread t3 = new Thread(()-> c1.increment());
        Thread t4 = new Thread(()-> c1.increment());
        Thread t5 = new Thread(()-> c1.increment());
        Thread t6 = new Thread(()-> c1.display());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        t6.start();
    }
}
