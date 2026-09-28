public class MultiThreading_Telusko25 {
    static int x = 0;
    static boolean flag = false;
    static void main(String[] args) {
        Thread t1 = new Thread(()->{
            x = 10;
            flag = true;
        });

        Thread t2 = new Thread(()->{
            if (flag == true){
                System.out.println(x);
            }
        });

        t1.start();
        t2.start();
    }
}
