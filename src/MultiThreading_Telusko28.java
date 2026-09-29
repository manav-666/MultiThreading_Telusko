class Test1{
    synchronized void m1(){
        System.out.println("m1 Enter");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println("m1 Exit");
    }
    synchronized void m2(){
        System.out.println("m2 Enter");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println("m2 Exit");
    }
}
public class MultiThreading_Telusko28 {
    static void main(String[] args) {
        Test1 test = new Test1();  //One Object -----> One Lock

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

