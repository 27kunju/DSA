package MultiThreading;

import java.util.*;
import java.util.concurrent.*;

public class ExecutorCallableExample {

    public static void main(String[] args) {

        // 1. Create ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Create list of Callable tasks
        List<Callable<Integer>> tasks = new ArrayList<>();

        tasks.add(() -> {
            Thread.sleep(1000);
            return 10;
        });

        tasks.add(() -> {
            Thread.sleep(1500);
            return 20;
        });

        tasks.add(() -> {
            Thread.sleep(500);
            return 30;
        });

        try {
            // 3. Invoke all tasks
            List<Future<Integer>> futures = executor.invokeAll(tasks);

            // 4. Get results
            for (Future<Integer> future : futures) {
                System.out.println("Result: " + future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 5. Shutdown executor
            executor.shutdown();
        }
    }
}
