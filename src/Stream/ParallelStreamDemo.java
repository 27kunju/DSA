package Stream;


import java.util.*;
import java.util.stream.IntStream;

public class ParallelStreamDemo {

    public static void main(String[] args) {
        // Large dataset
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .toList();

        // -------------------------------
        // 1️⃣ Sequential Stream
        // -------------------------------
        long startSequential = System.currentTimeMillis();

        long sumSequential = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();

        long endSequential = System.currentTimeMillis();
        System.out.println("Sequential sum: " + sumSequential);
        System.out.println("Time taken (Sequential): " + (endSequential - startSequential) + " ms");

        // -------------------------------
        // 2️⃣ Parallel Stream
        // -------------------------------
        long startParallel = System.currentTimeMillis();

        long sumParallel = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();

        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel sum: " + sumParallel);
        System.out.println("Time taken (Parallel): " + (endParallel - startParallel) + " ms");
    }
}
