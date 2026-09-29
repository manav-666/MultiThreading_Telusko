public class MultiThreading_Telusko27 {
    static void main(String[] args) {
        Test test1 = new Test();

        Thread t1 = new Thread(() ->{
            test1.show();
            test1.disp();
        });

        Thread t2 = new Thread(()->{
            test1.show();
            test1.disp();
        });

        t1.start();
        t2.start();

    }
}

//Why do we need synchronized ?
        //To protect shared data.
        //To make any operation atomic.
        //To ensure visibility.
        //To prevent the re-ordering

class Test{
    synchronized void show(){
        System.out.println(Thread.currentThread().getName() + " Inside Show");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " Show finished");
    }
    void disp(){
        System.out.println(Thread.currentThread().getName() + " display");
    }
}
