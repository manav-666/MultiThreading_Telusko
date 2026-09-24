public class MultiThreading_Telusko9 {

    static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0){
                    System.out.println("T1 : " + i);
                }
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i <= 100 ; i++) {
                if (i % 2 != 0){
                    System.out.println("T2 : " + i);
                }
            }
        });

        Thread t3 = new Thread(() ->{
            for (int i = 0; i <= 100 ; i++) {
                System.out.println("T3 : " + i);
            }
        });

        t1.start();

        t2.start();

        t3.start();

    }
}
