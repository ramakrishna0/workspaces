import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello world!");
        //ExecutorService allows us to execute tasks on threads asynchronously
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //getting future
        //the method submit() submits a value-returning task for execution and returns the Future
        Future<String> future = executorService.submit(() ->
        {
            System.out.println("Start of future 1");
            //sleep thread for 2 seconds
            Thread.sleep(2000);
            return "Welcome to Javatpoint";
        });
        Future<String> future2 = executorService.submit(() ->
        {
            System.out.println("Start of future 2");
            //sleep thread for 2 seconds
            Thread.sleep(2000);
            return "Welcome to Future";
        });
        //checks if the task is completed or not
        while (!future.isDone()) {
            System.out.println("The task is still in process.....");
            //sleep thread for 2 milliseconds
            Thread.sleep(200);
        }
        System.out.println("Task completed! getting the result");
        //getting the result after completing the task
        String result = future.get();
        String result2 = future2.get();
        //prints the result
        System.out.println(result);
        System.out.println(result2);



        System.out.println("------------------------------------------------------------------------------------------");
        MyFuture myFuture = new MyFuture();

        Future<Set<Integer>> future3 = executorService.submit(() -> {
            return myFuture.trial1();
        });
        Future<Set<Integer>> future4 = executorService.submit(() -> {
            return myFuture.trial2();
        });
        System.out.println(future4.get());
        System.out.println(future3.get());
        executorService.shutdown();*/
        System.out.println("------------------------------------------------------------------------------------------");
        long startOfCompleteFuture = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Set<Integer>> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                return new MyFuture().trial1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);/*.thenApply(result -> {
            System.out.println(result);
            System.out.println("time: " + startOfCompleteFuture);
            return result;
        });*/

        CompletableFuture<Set<Integer>> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                return new MyFuture().trial2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);/*.thenApply(result -> {
            System.out.println("time: " + startOfCompleteFuture);
            System.out.println(result);
            return result;
        });*/



        completableFuture1.whenComplete((res, throwable) -> {
            System.out.println(res);
            System.out.println("execution time: " + (System.currentTimeMillis() - startOfCompleteFuture) );
        });

        completableFuture2.whenComplete((res, throwable) -> {
            System.out.println(res);
            System.out.println("execution time: " + (System.currentTimeMillis() - startOfCompleteFuture) );
        });
        System.out.println("End of Main");
        executorService.shutdown();
        executorService.awaitTermination(1000000, TimeUnit.SECONDS);


        //List<CompletableFuture> futureList = CompletableFuture.allOf(new List[completableFuture1, completableFuture2]);


    }



}