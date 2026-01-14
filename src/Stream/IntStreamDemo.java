package Stream;


import java.util.*;
import java.util.stream.*;

public class IntStreamDemo {
    public static void main(String[] args) {
        System.out.println("---- 1️⃣ IntStream from range ----");
        IntStream.range(1, 5) // 1,2,3,4
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        IntStream.rangeClosed(1, 5) // 1,2,3,4,5
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 2️⃣ IntStream from array ----");
        int[] arr = {5, 3, 1, 3, 2};
        IntStream.of(arr)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 3️⃣ Filter even numbers ----");
        IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 4️⃣ Map (square each number) ----");
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 5️⃣ Sum, Average, Max, Min ----");
        int sum = IntStream.rangeClosed(1, 5).sum();
        double avg = IntStream.rangeClosed(1, 5).average().orElse(0);
        int max = IntStream.rangeClosed(1, 5).max().orElse(0);
        int min = IntStream.rangeClosed(1, 5).min().orElse(0);
        System.out.println("Sum: " + sum + ", Avg: " + avg + ", Max: " + max + ", Min: " + min);
        System.out.println();

        System.out.println("---- 6️⃣ Distinct & Sorted ----");
        IntStream.of(arr)
                .distinct()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 7️⃣ Parallel IntStream ----");
        long start = System.currentTimeMillis();
        long parallelSum = IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .sum();
        long end = System.currentTimeMillis();
        System.out.println("Parallel sum of 1 to 1,000,000: " + parallelSum);
        System.out.println("Time taken: " + (end - start) + " ms\n");

        System.out.println("---- 8️⃣ Custom example: Sum of squares of even numbers ----");
        int sumSquares = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of squares of even numbers 1-10: " + sumSquares + "\n");

        System.out.println("---- 9️⃣ Generate first 5 even numbers using iterate ----");
        IntStream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("---- 🔟 Random integers using generate ----");
        new Random().ints(5, 1, 100) // 5 random ints between 1-99
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
