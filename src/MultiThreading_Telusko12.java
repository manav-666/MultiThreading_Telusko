class MyCar implements Runnable{
    @Override
    synchronized public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + " has entered parking lot");
            System.out.println();
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has  entered into Car");
            System.out.println();
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has started to drive the car");
            System.out.println();
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has came back and parked the car");
            System.out.println();
        } catch (Exception e) {

        }
    }
}
public class MultiThreading_Telusko12 {
    static void main(String[] args) {
        MyCar car = new MyCar();

        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);

        t1.setName("RAMESH");
        t2.setName("SURESH");
        t3.setName("DINESH");

        t1.start();
        t2.start();
        t3.start();

    }
}
