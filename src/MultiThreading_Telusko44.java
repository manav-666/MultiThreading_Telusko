class BankAccount{
    int balance =1000;

    void withdraw(int amount){
        synchronized (this) {
            if (balance < amount) {
                System.out.println("Insufficient Balance");
            } else {
                balance = balance - amount;
            }
        }
    }

    void displayBalance(){
        System.out.println("Balance: " + balance);
    }
}
public class MultiThreading_Telusko44 {
    static void main(String[] args)throws InterruptedException {
        BankAccount acc1 = new BankAccount();

        Thread t1 = new Thread(()->{
            acc1.withdraw(700);
        });

        Thread t2 = new Thread(()->{
            acc1.withdraw(500);
            acc1.displayBalance();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
