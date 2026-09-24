public class MultiThreading_Telusko1 {
    static void main(String[] args)throws InterruptedException {
        System.out.println("Application Started........");

        //Thread.sleep(5000);
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName());   //Default Thread in Java: --> Main
        System.out.println(thread.getPriority());   //Default Priority : -->  5

        Thread.sleep(5000);

        thread.setName("Telusko");
        thread.setPriority(4);

        System.out.println(thread.getName());
        System.out.println(thread.getPriority());

        System.out.println("Application Terminated.............");
    }
}
