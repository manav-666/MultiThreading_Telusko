class RailwayStation{
    boolean trainArrived = false;
    boolean passengerBoarded = false;
    boolean trainDeparture =false;

    synchronized public void setTrainArrived(){
        System.out.println("Train is Arrived....");
        trainArrived = true;
        notifyAll();
    }

    synchronized public void setPassengerBoarded() throws InterruptedException{
        while(!trainArrived){
            wait();
        }

        System.out.println("Passenger are boarding.....");
        passengerBoarded = true;
        notifyAll();
    }

    synchronized public void setTrainDeparture()throws InterruptedException{
        while(!passengerBoarded){
            wait();
        }

        System.out.println("Train is Departure....");
        trainDeparture = true;
        notifyAll();
    }
}
public class MultiThreading_Telusko48 {
    static void main(String[] args)throws InterruptedException {
      RailwayStation rs1 = new RailwayStation();

      Thread t1 = new Thread(()->{
          try{
              rs1.setTrainArrived();
          } catch (Exception e) {}
      });

      Thread t2 = new Thread(()->{
          try{
              rs1.setPassengerBoarded();
          } catch (Exception e) {}
      });

      Thread t3 = new Thread(()->{
          try{
              rs1.setTrainDeparture();
          } catch (Exception e) {}
      });

      t1.start();
      t2.start();
      t3.start();

      t1.join();
      t2.join();
      t3.join();
    }
}
