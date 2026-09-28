public class MultiThreading_Telusko27 {
    static void main(String[] args) {
        Test test1 = new Test();

        Thread t1 = new Thread(() ->{
            test1.show();
        });

        Thread t2 = new Thread(()->{
            test1.show();
        });

        t1.start();
        t2.start();

    }
}

class Test{
    synchronized void show(){
        System.out.println(Thread.currentThread().getName() + " Inside Show");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " Show finished");
    }
}
