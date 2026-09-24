class Mythreading extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running......");
    }
}
public class MultiThreading_Telusko5 {
    static void main(String[] args) {
        Mythreading mythreading = new Mythreading();
        mythreading.start();
    }
}
