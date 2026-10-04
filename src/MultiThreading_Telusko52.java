import java.util.concurrent.*;

public class MultiThreading_Telusko52 {
    static void main(String[] args) {
        ExecutorService service1 = Executors.newFixedThreadPool(1);
        //ExecutorService service2 = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () ->{
            return 25 + 35;
        };

        Callable<Integer> task2 = () ->{
            return 10+20;
        };

        Callable<Integer> task3 = () ->{
            return 50 * 2;
        };

        Callable<Integer> task4 = () ->{
            return  100 - 40;
        };

        Future<Integer> result1 = service1.submit(task);

        //Future<Integer> result2 = service2.submit(task2);

        Future<Integer> result3 = service1.submit(task3);

        Future<Integer> result4 = service1.submit(task4);

        try {
            System.out.println("Result: " + result1.get());
            System.out.println("Result: " + result3.get());
            System.out.println("Result: " + result4.get());
        }catch (Exception e){}

//        try {
//            System.out.println("Result: " + result2.get());
//        }catch (Exception e){}

        service1.shutdown();
        //service2.shutdown();
    }
}
