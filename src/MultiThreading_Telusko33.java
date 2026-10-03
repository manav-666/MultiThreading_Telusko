class Box1{
    volatile Integer item;
    volatile Boolean flag = false;

    void producer(int value){
        while(flag == true){
            //do nothing
        }

         item = value;
        flag = true;
        System.out.println("Producer produces " + item);
    }

    void counsumer(){
        while(flag == false){
            //do nothing
        }
        System.out.println("Consumer consumes " + item);
        item = null;
        flag = false;
    }
}
public class MultiThreading_Telusko33 {
    static void main(String[] args) {
        Box1 box = new Box1();

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
