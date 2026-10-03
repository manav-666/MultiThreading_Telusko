class Factory{
    boolean Factory = true;
    boolean cuttingDone = false;
    boolean assemblyDone = false;
    boolean packingDone = false;

    synchronized void factoryWork() throws InterruptedException{

        if (Factory == true){
            System.out.println("Cutting machine waiting...");
            System.out.println("Assembly machine waiting...");
            System.out.println("Packaging machine waiting...");
        }

        notifyAll();
    }

   synchronized void CuttingMachine()throws InterruptedException{

       System.out.println("Cutting Machine is Started!");
       System.out.println("Cutting Completed!!!");
        cuttingDone = true;
        notifyAll();
    }

    synchronized void assemblyDone()throws InterruptedException{
        while(cuttingDone != true){
            wait();
        }
        System.out.println("Assembly Machine is Started!");
        System.out.println("Assembly Completed!!!");
        assemblyDone = true;
        notifyAll();
    }

    synchronized void packingDone()throws InterruptedException{
        while(assemblyDone != true){
            wait();
        }
        System.out.println("Packaging Machine is Started!");
        System.out.println("Packaging Completed!!!");
        packingDone = true;
        notifyAll();
    }
}
public class MultiThreading_Telusko47 {
    static void main(String[] args) throws InterruptedException {
        Factory fc = new Factory();

        Thread t1 = new Thread(()->{
            try{
                fc.factoryWork();
            } catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(()->{
            try{
                fc.CuttingMachine();
            } catch (InterruptedException e) {}
        });

        Thread t3 = new Thread(()->{
            try{
                fc.assemblyDone();
            } catch (InterruptedException e) {}
        });

        Thread t4 = new Thread(()->{
            try{
                fc.packingDone();
            } catch (InterruptedException e) {}
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

//        t1.join();
//        t2.join();
//        t3.join();
//        t4.join();

    }
}
