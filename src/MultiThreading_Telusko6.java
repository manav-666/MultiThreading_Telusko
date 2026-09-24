//  Runnable Interface Implements
class myRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is Running.......");
    }
}

public class MultiThreading_Telusko6 {
    static void main(String[] args) {

        myRunnable r1 = new myRunnable();

        Thread t1 = new Thread(r1);

        System.out.println(t1.getName());   //Thread-0

        System.out.println(t1.getId()); //26

        t1.start();
    }
}
