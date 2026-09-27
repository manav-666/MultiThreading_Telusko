public class MultiThreading_Telusko17 {
    static void main(String[] args)throws InterruptedException {
        Thread t1 = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Running");
            }
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Is Interrupted");
            }
        });

        t1.start();

        Thread.sleep(2000);

        t1.interrupt();
    }
}

/*
* Thread --> Interrupt flag (default True)
*
* t1.interrupt() --> Sends a signal to t1 thread that it should stop doing what its doing.
*
* We can gracefully Handle.
*
* --> You can make a thread run until a condition.
* -->Cancelling a long-running task.
* -->Used to sleep stop Thread pool.
*
*   isInterrupted() --> return interrupt flag value (True/False).
*   interrupted() ----> return interrupted fla valur (True/ False) but also set it back to false
*
* */