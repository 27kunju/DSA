package MultiThreading;

import java.util.concurrent.*;

public class CompletableFutureNonBlocking {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 10;
                }, executor);

        System.out.println("Before callback");

        // NON-BLOCKING
        future.thenAccept(result ->
                System.out.println("Result: " + result)
        );

        System.out.println("After callback");

        executor.shutdown();
    }
}

