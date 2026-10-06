import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class LikeCounter{
    AtomicReference<Integer> totalCount= new AtomicReference<>(0);

    //AtomicInteger totalCount = new AtomicInteger(0); //Different method

    public void like(){

        //totalCount.getAndIncrement();//Different Method

        //totalCount.set(totalCount.get() + 1); // It get the Raise Condition.

        Integer currentCount;
        Integer finalCount;

        while(true){
            //1. We will Capture the latest value of totalCount;
                    currentCount = totalCount.get();

            //2. Increment like counter by 1
                    finalCount = currentCount + 1;

            //3. Check again, If the count is still What I saw.
                    if(totalCount.compareAndSet(currentCount, finalCount)){
                        return;
                    }

             //4. If a thread reaches here, someone else must have updated then
             //Re-try...

            System.out.println("Conflict Detected. Re-trying......");
            System.out.println(totalCount);
        }
    }


    public int getTotalCount(){
        return totalCount.get();
    }
}
public class MultiThreading_Telusko61 {
    static void main(String[] args) {
        LikeCounter lc = new LikeCounter();

        Thread t1 = new Thread(()-> lc.like());

        Thread t2 = new Thread(()-> lc.like());

        Thread t3 = new Thread(()-> lc.like());

        //Thread t4 = new Thread(()-> lc.like());

        Thread t4 = new Thread(()->{
            for (int i = 1; i <=1000 ; i++) {
                lc.like();
            }
        });

        Thread t5 = new Thread(()-> lc.like());

        Thread t6 = new Thread(()-> lc.like());

        Thread t7 = new Thread(()-> lc.like());

        Thread t8 = new Thread(()-> lc.like());

        Thread t9 = new Thread(()-> lc.like());

        Thread t10 = new Thread(()-> lc.like());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        System.out.println(lc.getTotalCount());
    }
}
