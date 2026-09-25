import java.util.Scanner;

class Mythreading1 extends Thread{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
//        if (threadName.equals("BANK")){
//            banking();
//        } else if (threadName.equals("STAR")) {
//            try {
//                bankprintstar();
//            } catch (InterruptedException e) {
//
//            }
//        }else{
//            try {
//                bankImpmsg();
//            } catch (InterruptedException e) {
//
//            }
//        }
        try {
            if (threadName.equals("BANK")){
                banking();
            } else if (threadName.equals("STAR")) {
                bankprintstar();
            }else {
                bankImpmsg();
            }
        } catch (InterruptedException e) {

        }
    }
    public void banking(){

        System.out.println("Banking Activity Started..");

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the user number: ");
        scan.nextInt();

        System.out.print("Enter the Password: ");
        scan.nextInt();

        System.out.println("Collect your Cash.");

        System.out.println("Banking Activity Terminated..");
    }

    public void bankprintstar() throws InterruptedException{
        System.out.println("Printing Activity started....");
        for (int i = 0; i <= 4; i++) {
            System.out.println("**");
            Thread.sleep(4000);
        }
        System.out.println("Printing Activity Terminated");
    }

    public void bankImpmsg()throws InterruptedException{
        System.out.println("Printing Important Message Started....");
        for (int i = 0; i <=4; i++) {
            System.out.println("Focus is the key to master any skill");
            Thread.sleep(4000);
        }
        System.out.println("Printing Important Message Terminated");
    }
}

public class MultiThreading_Telusko11 {
    static void main(String[] args) {
        System.out.println("Application Started");
        Mythreading1 mt1 = new Mythreading1();

        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt1);
        Thread t3 = new Thread(mt1);

        t1.setName("BANK");
        t2.setName("STAR");
        t3.setName("FOCUS");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Application is Terminated");
    }
}
