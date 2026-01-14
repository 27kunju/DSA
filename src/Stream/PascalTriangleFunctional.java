package Stream;

import java.util.*;
import java.util.stream.*;

public class PascalTriangleFunctional {
    public static void main(String[] args) {
        int rows = 5;

        // Generate Pascal's Triangle row by row
        IntStream.rangeClosed(0, rows - 1)
                .forEach(i -> {
                    // Print leading spaces
                    String spaces = IntStream.range(0, rows - i - 1)
                            .mapToObj(n -> " ")
                            .collect(Collectors.joining());
                    System.out.print(spaces);

                    // Generate row values using streams
                    String row = IntStream.rangeClosed(0, i)
                            .mapToObj(j -> String.valueOf(combination(i, j)))
                            .collect(Collectors.joining(" "));
                    System.out.println(row);
                });
    }

    // nCr calculation using iterative method
    private static int combination(int n, int r) {
        if (r == 0 || r == n) return 1;
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }
}
