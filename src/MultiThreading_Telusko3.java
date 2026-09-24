//
//                                            THREAD CREATION
//                                                  │
//                                  ┌───────────────┴────────────────┐
//                                  │                                │
//                                  ▼                                ▼
//                             EXTEND THREAD                    IMPLEMENT RUNNABLE
//                                  │                                │
//                                  ▼                                ▼
//                          class A extends Thread          class A implements Runnable
//                                  │                                │
//                                  ▼                                ▼
//                             public void run()               public void run()
//                                  │                                │
//                                  ▼                                ▼
//                              A t = new A();                  A obj = new A();
//                                  │                                │
//                                  │                                ▼
//                                  │                       Thread t = new Thread(obj);
//                                  │                                │
//                                  └──────────────┬─────────────────┘
//                                                 ▼
//                                              t.start()
//                                                 │
//                                                 ▼
//                                        JVM creates new thread
//                                                 │
//                                                 ▼
//                                               run()

import java.util.Scanner;

class Alpha1 extends Thread{

    @Override
    public void run() {

        banking();
    }
    public void banking(){
        System.out.println("Banking Activity Started..");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the user number: ");
        int un = scan.nextInt();

        System.out.print("Enter the Password: ");
        int pass = scan.nextInt();

        System.out.println("Collect your Cash.");

        System.out.println("Banking Activity Terminated..");
    }
}

class Beta1 extends Thread{

    @Override
    public void run(){
        try {
            bankprintstar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void bankprintstar() throws InterruptedException{
        System.out.println("Printing Activity started....");
        for (int i = 0; i <= 4; i++) {
            System.out.println("**");
            Thread.sleep(4000);
        }
        System.out.println("Printing Activity Terminated");
    }
}

class Gamma1 extends Thread{

    @Override
    public void run(){
        try {
            bankImpmsg();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
public class MultiThreading_Telusko3 {
    static void main(String[] args)throws InterruptedException {
//        System.out.println("Application Started.........");
//        System.out.println("Banking Activity Started..");
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("Enter the user number: ");
//        int un = scan.nextInt();
//
//        System.out.print("Enter the Password: ");
//        int pass = scan.nextInt();
//
//        System.out.println("Collect your Cash.");
//        System.out.println("Printing Activity started....");
//        for (int i = 0; i <= 4; i++) {
//            System.out.println("**");
//            Thread.sleep(4000);
//        }


//        System.out.println("Printing Activity Terminated");
//
//        System.out.println("Printing Important Message Started....");
//        for (int i = 0; i <=4; i++) {
//            System.out.println("Focus is the key to master any skill");
//            Thread.sleep(4000);
//        }
//        System.out.println("Printing Important Message Terminated");

        Alpha1 a = new Alpha1();
        Beta1 b = new Beta1();
        Gamma1 g = new Gamma1();

        a.start();
        b.start();
        g.start();

//        a.banking();
//        b.bankprintstar();
//        g.bankImpmsg();

        System.out.println("Application Terminated..........");
    }
}
