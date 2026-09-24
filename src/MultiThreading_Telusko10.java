import java.util.Scanner;

public class MultiThreading_Telusko10 {
    static void main(String[] args)throws InterruptedException {
        //Thread new Stage

        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(() ->{
//            Scanner scan = new Scanner(System.in);
//
//            System.out.println("Enter the Name: ");
//            String name = scan.nextLine();

            System.out.println("Name of Current Thread is: " + Thread.currentThread().getName());

            System.out.println(mainThread.getState());  //TIMED_WAITING
        });

        System.out.println(t1.getState());  //NEW

        t1.start();

        System.out.println(t1.getState());  //RUNNABLE

        Thread.sleep(5000);

        System.out.println(t1.getState());  //TERMINATED
    }
}
