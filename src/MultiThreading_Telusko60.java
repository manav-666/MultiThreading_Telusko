import java.util.concurrent.atomic.AtomicReference;

class SeatBooking{
    //String seat = new String("EMPTY");

//    boolean bookSeat(String name){
//        if(seat.equals("EMPTY")){
//            seat = new String(name);
//            return true;
//        }
//        return false;
//    }
//
    AtomicReference<String> seat = new AtomicReference<>("EMPTY");

    boolean bookSeat(String name){
        String currentValue =  seat.get();
        if (currentValue.equals("EMPTY") == false){
            return false;
        }

        return seat.compareAndSet("EMPTY", name);
        /*
        * if(seat.equals("EMPTY")){
        *    seat = new String(name);
        *    return true;
        * }
        */
    }
}
public class MultiThreading_Telusko60 {
    static void main(String[] args) {
        SeatBooking sb = new SeatBooking();

        Thread t1 = new Thread(() -> sb.bookSeat("Aditya"));
        Thread t2 = new Thread(() -> sb.bookSeat("Rohit"));

        t1.start();
        t2.start();

        try{
            Thread.sleep(2000);
        }catch (Exception e) {}

        System.out.println(sb.seat);
    }
}
