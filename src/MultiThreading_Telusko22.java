class Counter implements Runnable{
    int count = 0;
    @Override
    public void run(){
        count++;
    }
}

public class MultiThreading_Telusko22 {
    static void main(String[] args)throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        Thread.sleep(2000);
        System.out.println(c.count);


    }
}
