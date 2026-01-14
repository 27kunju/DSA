package Stream;

import java.util.*;
import java.util.stream.IntStream;

public class PascalTriangleIntStream {
    public static void main(String[] args) {
        int rows = 5; // number of rows in Pascal's Triangle

        // Generate Pascal's Triangle row by row
        IntStream.rangeClosed(0, rows - 1).forEach(i -> {
            // Print leading spaces for formatting
            IntStream.range(0, rows - i - 1).forEach(n -> System.out.print(" "));

            // Generate values in row using combinatorial formula
            IntStream.rangeClosed(0, i).forEach(j -> {
                System.out.print(combination(i, j) + " ");
            });

            System.out.println();
        });
    }

    // Function to calculate nCr (combinations)
    private static int combination(int n, int r) {
        if (r == 0 || r == n) return 1;

        // Use iterative multiplication to avoid recursion
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }
}
