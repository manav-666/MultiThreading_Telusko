public class MultiThreading_Telusko8 {
    static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Threading is Running.....");
            System.out.println("");
            System.out.println("Current Threading " + Thread.currentThread().getName());
        });
        //t1.start();
        t1.run(); //This run() method will not create the new thread until we call the start() method...!
    }
}
