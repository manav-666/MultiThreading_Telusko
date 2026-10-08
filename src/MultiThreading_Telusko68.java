import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SunTask extends RecursiveTask<Integer>{
    private int[] arr;
    private int start;
    private int end;

    public SunTask(int[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute(){

        //Base Condition
        if (end - start <= 2){
            int sum = 0;
            for (int i = start; i<=end; i++){
                sum += arr[i];
            }
            return sum;
        }

        //main logic ---> fork
        int mid = (start + end)/2;
        SunTask leftTask = new SunTask(arr, start, mid);
        SunTask rightTask = new SunTask(arr, mid+1, end);

        leftTask.fork();

        int sum2 = rightTask.compute();

        int sum1 = leftTask.join();

        //join
        return sum1 + sum2;
    }
}
public class MultiThreading_Telusko68 {
    static void main(String[] args) {
        //Fork Join Pool Executor
        int arr[] = {1,2,3,4,5,6,7,8};

        ForkJoinPool pool = new ForkJoinPool();

        SunTask task = new SunTask(arr, 0 , arr.length-1);

        int result = pool.invoke(task);

        System.out.println(result);

        pool.shutdown();
    }
}
