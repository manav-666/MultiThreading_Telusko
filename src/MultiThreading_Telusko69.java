public class MultiThreading_Telusko69 {
    static void main(String[] args) {
      Thread t1 = Thread.startVirtualThread(()->{
          System.out.println(Thread.currentThread() + " Says hello");
      });

      try{
          t1.join();
      }catch (Exception e){}
    }
}
