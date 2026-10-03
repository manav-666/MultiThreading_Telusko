class TrafficSignal{
    boolean green = false;

    synchronized void waitForGreen()throws InterruptedException{
        while (green == false){
            System.out.println("Car is waiting for signal....");

            wait();
        }
    }

    synchronized void makeGreen(){

        System.out.println("Signal is green now.....");
        green = true;
        notify();
    }
}
public class MultiThreading_Telusko46 {
    static void main(String[] args) throws InterruptedException{
        TrafficSignal trafficSignal = new TrafficSignal();

        Thread waitForGreen = new Thread(() ->{
            try{
                trafficSignal.waitForGreen();
            } catch (InterruptedException e) {}
        });

        Thread makeGreen = new Thread(() ->{
            try{
                trafficSignal.makeGreen();
                System.out.println("Car can go!!!");
            } catch (Exception e) {}
        });

        waitForGreen.start();
        makeGreen.start();

        waitForGreen.join();
        makeGreen.join();
    }
}
