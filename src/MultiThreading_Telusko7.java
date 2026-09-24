public class MultiThreading_Telusko7 {
    static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());

        // Using the Lambda Expression
        Thread t1 = new Thread(() -> {
//            try{
//                Thread.sleep(5000);
//            }catch (InterruptedException e){
//
//            }
            System.out.println("Name of my thread is " + Thread.currentThread().getName());
            System.out.println("Id of my thread is " + Thread.currentThread().getId());
        });

        //t1.start();

        Thread t2 = new Thread(() -> {
//            try{
//                Thread.sleep(5000);
//            }catch (InterruptedException e){
//
//            }
            System.out.println("Name of my thread 2 is " + Thread.currentThread().getName());
            System.out.println("Id of my thread is " + Thread.currentThread().getId());
        });

        t1.start();
        t2.start();
    }
}
