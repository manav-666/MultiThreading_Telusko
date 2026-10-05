class Producer extends Thread{
    Queue q;
    int i = 1;

    public Producer(Queue q){
        this.q = q;
    }

    @Override
    public void run(){
        while(true){
            q.produce(i++);
        }
    }
}

class Consumer extends Thread{
    Queue q;

    public Consumer(Queue q){
        this.q = q;
    }
    @Override
    public void run(){
       while(true){
           q.consume();
       }
   }
}

class Queue{
    int data;

    public void produce(int i){
        data = i;
        System.out.println("I have produced Data " + data );
    }

    public void consume(){
        System.out.println("I have consumed Data " + data );
    }
}
public class MultiThreading_Telusko56 {
    static void main(String[] args) {
        Queue q = new Queue();

        Producer produce = new Producer(q);
        Consumer consume = new Consumer(q);

        produce.start();
        consume.start();
    }
}
