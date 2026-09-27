public class MultiThreading_Telusko21 {

    static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            while (true){
                System.out.println("Running......");
            }
        });
        t1.setDaemon(true);
        t1.start();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
}

/*
* Daemon Thread --->  Background Running Threads.
* --> Stops immediately once main thread is completed.
*
* Threads --> User Threads, Daemon Threads
*
* Garbage Collection    --> Daemon Thread.....
*
* Threads   --->    User Threads, Daemon Threads
*
* */