class Box2{
    Integer value;
    Boolean available = false;

    synchronized void put(int v) throws InterruptedException{
        while (available == true){
            wait();
        }

        value = v;
        available = true;
        System.out.println("Value Producer: " + value);
        notify();
    }

    synchronized void get()throws InterruptedException{
        while (available == false){
            wait();
        }

        System.out.println("Value getted: " + value);
        value = null;
        available = false;
        notify();
    }
}
public class MultiThreading_Telusko45 {
    static void main(String[] args) {
        Box2 b2 = new Box2();

        Thread t1 = new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try{
                    b2.put(i);
                } catch (Exception e) {}
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try{
                    b2.get();
                } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
    }
}
