package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {
        // Step 1: Create Callable task
        Callable<Integer> task = () -> {
            return 10;
        };

        // Step 2: Create ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            // Step 3: Submit task and get Future
            Future<Integer> future = executor.submit(task);

            // Step 4: Get result (blocks until task completes)
            Integer result = future.get();
            System.out.println("Result from Callable: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 5: Shutdown executor
            executor.shutdown();
        }
    }
}

