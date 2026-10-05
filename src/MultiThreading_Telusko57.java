import jdk.jfr.Threshold;

class Producer1 extends Thread{
    Queue1 q;
    int i = 1;

    public Producer1(Queue1 q){
        this.q = q;
    }

    @Override
    public void run(){
        try{
            while(true){
                q.produce(i++);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {}
    }
}

class Consumer1 extends Thread{
    Queue1 q;

    public Consumer1(Queue1 q){
        this.q = q;
    }
    @Override
    public void run(){
        try{
            while(true){
                q.consume();
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {}
    }
}

class Queue1{
    int data;
    boolean flag = false;

    synchronized public void produce(int i){
        try{
            if (flag == true){
                System.out.println("Producer is in Waiting state.");
                wait();
            }else{
                data = i;
                System.out.println("I have produced Data " + data );
                flag = true;
                notify();
            }
        } catch (Exception _) {}
    }

    synchronized public void consume(){
        try{
            if (flag == false){
                System.out.println("Producer is in Waiting state.");
                wait();
            }else {
                System.out.println("I have consumed Data " + data);
                flag = false;
                notify();
            }
        } catch (Exception _) {}
    }
}
public class MultiThreading_Telusko57 {
    static void main(String[] args) {
        Queue1 q = new Queue1();

        Producer1 produce = new Producer1(q);
        Consumer1 consume = new Consumer1(q);

        produce.start();
        consume.start();
    }
}
