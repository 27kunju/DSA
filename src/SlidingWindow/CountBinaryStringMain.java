package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class CountBinaryStringMain {

    public static boolean countBinaryString(String binary_format, int k) {

        Set<String> cache = new HashSet<>();
        int i = 0, j = 0;

        while (j < binary_format.length()) {

            // Expand window until size == k
            if (j - i + 1 < k) {
                j++;
            }
            // When window size hits k
            else if (j - i + 1 == k) {

                // Correct substring: j is included → j + 1
                String sub = binary_format.substring(i, j + 1);

                cache.add(sub);

                // Slide the window
                i++;
                j++;
            }
        }

        int totalPossible = 1 << k;   // 2^k possible binary strings

        return cache.size() == totalPossible;
    }

    public static void main(String[] args) {
        System.out.println(countBinaryString("00110110", 2)); // true
    }
}
