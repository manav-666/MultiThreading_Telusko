import java.util.Scanner;
class Alpha{
    public void banking(){

        System.out.println("Banking Activity Started..");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the user number: ");
        int un = scan.nextInt();

        System.out.print("Enter the Password: ");
        int pass = scan.nextInt();

        System.out.println("Collect your Cash.");
    }
}

class Beta{
    public void bankprintstar() throws InterruptedException{
        for (int i = 0; i <= 4; i++) {
            System.out.println("**");
            Thread.sleep(1000);
        }
    }
}

class Gamma{
    public void bankImpmsg()throws InterruptedException{
        for (int i = 0; i <=4; i++) {
            System.out.println("Focus is the key to master any skill");
            Thread.sleep(1500);
        }
    }
}
public class MultiThreading_Telusko2 {
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
        Alpha a = new Alpha();
        a.banking();

        System.out.println("Banking Activity Terminated..");

        System.out.println("Printing Activity started....");
//        for (int i = 0; i <= 4; i++) {
//            System.out.println("**");
//            Thread.sleep(4000);
//        }
        Beta b = new Beta();
        b.bankprintstar();

        System.out.println("Printing Activity Terminated");

        System.out.println("Printing Important Message Started....");
//        for (int i = 0; i <=4; i++) {
//            System.out.println("Focus is the key to master any skill");
//            Thread.sleep(4000);
//        }
        Gamma g = new Gamma();
        g.bankImpmsg();

        System.out.println("Printing Important Message Terminated");
        System.out.println("Application Terminated..........");
    }
}
