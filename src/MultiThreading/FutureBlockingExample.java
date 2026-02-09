package MultiThreading;

import java.util.concurrent.*;

public class FutureBlockingExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(3000); // simulate long task
            return 10;
        });

        System.out.println("Before get()");

        // BLOCKING CALL
        Integer result = future.get();

        System.out.println("Result: " + result);
        System.out.println("After get()");

        executor.shutdown();
    }
}
