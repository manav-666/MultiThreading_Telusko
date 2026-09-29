class Test3{
    void m1(){
        synchronized (this){
            System.out.println("m1 Enter");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }

            System.out.println("m1 Exit");
        }
    }
    void m2(){
        synchronized (this){
            System.out.println("m2 Enter");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }

            System.out.println("m2 Exit");
        }
    }
}
public class MultiThreading_Telusko31 {
    static void main(String[] args) {
        Test3 test = new Test3();  //One Object -----> One Lock

        Thread t1 = new Thread(() ->{
            test.m1();
        });

        Thread t2 = new Thread(()->{
            test.m2();
        });

        t1.start();
        t2.start();
    }
}

