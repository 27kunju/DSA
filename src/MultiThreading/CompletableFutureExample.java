package MultiThreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Integer>> futures = List.of(
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return 10;
                }, executor),

                CompletableFuture.supplyAsync(() -> {
                    sleep(1500);
                    return 20;
                }, executor),

                CompletableFuture.supplyAsync(() -> {
                    sleep(500);
                    return 30;
                }, executor)
        );

        // Combine all futures
        CompletableFuture<Void> allDone =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Get results AFTER all complete
        List<Integer> results = allDone.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        ).join();

        System.out.println(results);

        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

