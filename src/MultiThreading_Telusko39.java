class Timer extends Thread{
    @Override
    public void run(){
        try{
            CountDown();
        } catch (InterruptedException e) {}
    }

    public void CountDown()throws InterruptedException{
            try{
                for (int i = 5; i >=0 ; i--) {
                    if (i>0){
                        System.out.println(Thread.currentThread().getName()+ " : " + i);
                        Thread.sleep(1000);
                    }else{
                        System.out.println("Time's Up!");
                    }
                }
            } catch (RuntimeException e) {}
    }

}
public class MultiThreading_Telusko39 {
    static void main(String[] args) {
        Timer t = new Timer();

        Thread CountdownThread = new Thread(t);

        CountdownThread.start();
    }
}
