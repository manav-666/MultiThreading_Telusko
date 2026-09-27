public class MultiThreading_Telusko20 {
    static void main(String[] args)throws InterruptedException {
        Thread t1 = new Thread(()-> System.out.println("Custom-1 Thread Running"));

        Thread t2 = new Thread(()-> System.out.println("Custom-2 Thread Running"));

        t1.start();
        t2.start();

        t2.setPriority(10);

        System.out.println(t1.getPriority());
    }
}

/*
* THREAD Priority
*  MINI_PRIORITY = 1;
*  MAX_PRIORITY = 10;
*  NORM_PRIORITY = 5;
*
* Depends on OS
* It may be,    --> Respect Priority
* It may be,    --> Partially respect
* It may be,    --> not at all
* */
