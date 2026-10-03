class Box3{
    volatile Integer item;
    volatile Boolean flag = false;

    synchronized void producer(int value) throws InterruptedException{
        while(flag == true){
            wait();
        }

        item = value;
        flag = true;
        notify();
        System.out.println("Producer produces " + item);
    }

    synchronized void counsumer() throws InterruptedException{
        while(flag == false){
            wait();
        }
        System.out.println("Consumer consumes " + item);
        item = null;
        flag = false;
        notify();
    }
}
public class MultiThreading_Telusko35 {
    static void main(String[] args) {
        Box3 box = new Box3();

        Thread t1 = new Thread(()->{
            for (int i = 0; i <=20 ; i++) {
                try{
                    Thread.sleep(100);
                    box.producer(i);
                } catch (InterruptedException e) {}

            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <=20 ; i++) {
                try{
                    Thread.sleep(100);
                    box.counsumer();
                } catch (InterruptedException e) {}

            }
        });

        t1.start();
        t2.start();
    }
}
