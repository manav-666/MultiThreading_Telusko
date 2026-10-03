import java.util.Scanner;

class Table{
    void printTable(int n){
        try{
            for (int i = 1; i <=10; i++) {
                System.out.println(n + " * " + i + " = " + (n * i));
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {}
    }
}
public class MultiThreading_Telusko38 {
    static void main(String[] args) {
        Table tab = new Table();

        Thread t1 = new Thread(()->{
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter the Number: ");

            tab.printTable(scan.nextInt());
        });

        t1.start();
    }
}
