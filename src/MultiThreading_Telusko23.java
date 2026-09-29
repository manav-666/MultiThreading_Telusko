class Counter1 {
    public int count = 0;

    synchronized void increment(){
        count++;
    }
}
public class MultiThreading_Telusko23 {
    static void main(String[] args)throws InterruptedException {
        Counter1 c1 = new Counter1();

        Thread t1 = new Thread(()-> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c1.count);
    }
}


//synchronized void increment(){
//    count++;
//}


//Always Remeber this:-
//        1) Read Count.
//        2) Increment By 1.
//        3) Update Memory.

//1) T1 aquire  the lock.
//2) T2 tries to go inside the increment but due to the T1 aquire the block of te code. It goes inside the block state
//3) First the T1 will perform or complete its task.
//4) As soon T1 exits the block. The T2 get enters into the block.