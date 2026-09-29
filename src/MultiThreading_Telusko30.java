class Counter3{
    static int count = 0;

    static void increment(){
        synchronized (Counter3.class){
            try{
                Thread.sleep(2000);
            }catch (Exception e){}

            count++;
            System.out.println(count);
        }
    }
}

public class MultiThreading_Telusko30 {
    static void main(String[] args) {
        Counter3 counter3 = new Counter3();

        Thread t1 = new Thread(()-> counter3.increment());

        Thread t2 = new Thread(()-> counter3.increment());

        t1.start();
        t2.start();
    }
}
