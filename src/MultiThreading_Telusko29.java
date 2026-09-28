class Bank{
    Object lock1 = new Object();
    Object lock2 = new Object();

    void m1(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " Entered m1");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " Exiting m1");
        }
    }

    void deposit(){
        synchronized (lock1){
            System.out.println("Deposit Logic");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {}

            System.out.println("Deposit Completed");
        }
    }

    void withdraw(){
        synchronized (lock2){
            System.out.println("Withdraw Logic");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println("Withdraw Completed");
        }
    }
}
public class MultiThreading_Telusko29 {
    static void main(String[] args) {
        Bank b1 = new Bank();

//        Thread t1 = new Thread(()->{
//           b1.deposit();
//        });
//
//        Thread t2 = new Thread(()->{
//            b1.withdraw();
//        });
        Thread t1 = new Thread(()->{
            b1.m1();
        });

        Thread t2 = new Thread(()->{
            b1.m1();
        });
        t1.start();
        t2.start();
    }
}
