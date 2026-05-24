package Interview.WissenTechnology;

import java.util.*;

/*
Divide integer N into 4 positive segments (a,b,c,d) such that:

a + b + c + d = N
No number appears more than 2 times
so x,x,x,y ❌ not allowed
x,x,y,y ✅ allowed
x,x,y,z ✅ allowed
x,y,z,w ✅ allowed
all 4 same (x,x,x,x) automatically rejected

N = 8

//(1,1,2,2)
(2,2,2,2)
(4,2,1,1)
(3,3,1,1)
(2,2,3,1)

5
(2,2,1)

We need count of valid ways (unique combinations).
 */


public class SegmentDivide {

    public static int countWays(int n) {

        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                for (int c = b; c <= n; c++) {

                    int d = n - (a + b + c);

                    if (d < c) continue;  // maintain sorted order
                    if (d <= 0) continue;

                    // Now we have a <= b <= c <= d

                    // frequency check
                    Map<Integer, Integer> freq = new HashMap<>();
                    freq.put(a, freq.getOrDefault(a, 0) + 1);
                    freq.put(b, freq.getOrDefault(b, 0) + 1);
                    freq.put(c, freq.getOrDefault(c, 0) + 1);
                    freq.put(d, freq.getOrDefault(d, 0) + 1);

                    boolean valid = true;
                    for (int f : freq.values()) {
                        if (f > 2) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));  // output should include [1,1,2,2]
    }
}
