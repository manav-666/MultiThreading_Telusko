
public class MultiThreading_Telusko24 {

    static volatile boolean flag = false; //true

    static void main(String[] args) {

     Thread t1 = new Thread(()->{
         try{
             Thread.sleep(1000);
         } catch (InterruptedException e) {}
         flag = true;   //cache ---> flag = true
     });
     Thread t2 = new Thread(()->{   //cache ---> flag = false
         while(!flag){
             //System.out.println("Threading 2 is Running....");
             //do nothing
         }
         System.out.println("Thread 2 finished");
     });

     t1.start();
     t2.start();
    }
}
