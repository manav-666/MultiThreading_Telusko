class Box{
    Integer item;
    Boolean flag = false;

    void producer(int value){
        item = value;
        flag = true;
        System.out.println("Producer produces " + item);
    }
    void counsumer(){
        System.out.println("Consumer consumes " + item);
        item = null;
        flag = false;
    }
}
public class MultiThreading_Telusko32 {
    static void main(String[] args) {
        Box box = new Box();

        Thread t1 = new Thread(()->{
            for (int i = 0; i <=20 ; i++) {
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                box.producer(i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <=20 ; i++) {
                try{
                    Thread.sleep(70);
                } catch (InterruptedException e) {}
                box.counsumer();
            }
        });

        t1.start();
        t2.start();
    }
}
