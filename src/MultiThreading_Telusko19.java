public class MultiThreading_Telusko19 {
    static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            System.out.println(Thread.currentThread().getName());
        });
        t1.setName("Worker-1");
        t1.start();

    }
}

/*
* currentThread() --> Reference of current running thread.
* setName() --> It is used to set the Name of Thread.
*/