class Counter4{
    int count = 0;

    void Increment(){
        for (int i = 1; i <= 1000 ; i++) {
            count++;
        }
    }

    void Display(){
        System.out.println("Count: " + count);
    }
}
public class MultiThreading_Telusko42 {
    static void main(String[] args) throws InterruptedException {
        Counter4 c1 = new Counter4();

        Thread t1 = new Thread(()->{
            c1.Increment();
        });

        Thread t2 = new Thread(()->{
            c1.Increment();
        });

        Thread t3 = new Thread(()->{
            c1.Increment();
        });

        Thread t4 = new Thread(()->{
            c1.Increment();
        });

        Thread t5 = new Thread(()->{
            c1.Increment();
        });

        Thread t6 = new Thread(()->{
            c1.Display();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
    }
}
