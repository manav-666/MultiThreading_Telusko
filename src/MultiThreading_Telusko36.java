class NumberThread extends Thread{
    @Override
    public void run(){
        try {
            print();
        } catch (InterruptedException e) {}
    }
    public void print()throws InterruptedException{
        try {
            for (int i = 1; i <=10 ; i++) {
                Thread.sleep(500);
                System.out.println(i);
            }
        } catch (InterruptedException e) {}
    }
}
public class MultiThreading_Telusko36 {
    static void main(String[] args) {
        NumberThread nt = new NumberThread();

        Thread t1 = new Thread(nt);

        t1.start();
    }
}
