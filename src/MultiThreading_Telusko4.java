import java.util.Scanner;

class Alpha2 implements Runnable{

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

class Beta2 implements Runnable{

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

class Gamma2 implements Runnable{

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

public class MultiThreading_Telusko4 {
    static void main(String[] args)throws InterruptedException {

        System.out.println("Application Started.........");
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

        Alpha2 a = new Alpha2();
        Beta2 b = new Beta2();
        Gamma2 g = new Gamma2();

        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(g);

//        System.out.println(thread1.isAlive());  //false
//        System.out.println(thread2.isAlive());  //false
//        System.out.println(thread3.isAlive());  //false

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();

//        a.start();
//        b.start();
//
//        a.join();
//        b.join();
//
//        g.start();
//        g.join();

//        System.out.println(thread1.isAlive());  //true
//        System.out.println(thread2.isAlive());  //true
//        System.out.println(thread3.isAlive());  //true

//        a.start();
//        b.start();
//        g.start();

//        a.banking();
//        b.bankprintstar();
//        g.bankImpmsg();

        System.out.println("Application Terminated..........");
    }
}
