class Numbers {
    synchronized void evenNumbers()throws Exception{
        try{
            for (int i = 0; i <=20 ; i++) {
                Thread.sleep(500);
                if (i % 2 == 0 ){
                    System.out.println(i);
                }
            }
        } catch (InterruptedException e) {}
    }

    synchronized void oddNumbers() throws Exception{
        try{
            for (int i = 0; i <=20 ; i++) {
                Thread.sleep(500);
                if (i % 2 != 0 ){
                    System.out.println(i);
                }
            }
        } catch (InterruptedException e) {}
    }

}
public class MultiThreading_Telusko37 {
    static void main(String[] args) {
        Numbers n = new Numbers();

        Thread t1 = new Thread(()->{
           try{
               n.evenNumbers();
           } catch (Exception e) {}
        });

        Thread t2 = new Thread(()->{
            try{
                n.oddNumbers();
            } catch (Exception e) {}
        });

        t1.start();
        t2.start();
    }
}
