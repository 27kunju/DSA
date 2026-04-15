package Trees;

import java.util.HashSet;
import java.util.*;

public class commonBoss {
    public  static int[] commonboss(int[] b, int[] e1, int[] e2) {
        int n = e1.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = getBoss(b, e1[i], e2[i]);
        }
        return res;
    }

    public static int getBoss(int[] b, int a, int x) {
        Set<Integer> ancestors = new HashSet<>();

        // store all ancestors of a
        while (a != -1) {
            ancestors.add(a);
            a = b[a];
        }

        // move x upwards until common found
        while (x != -1) {
            if (ancestors.contains(x)) {
                return x;
            }
            x = b[x];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] boss = {-1, 0, 0, 2, 3, 2};

        int[] e1 = {4, 5, 1};
        int[] e2 = {5, 1, 2};

        int[] result = commonboss(boss, e1, e2);

        System.out.println(Arrays.toString(result));
        // Output: [2, 0, 0]
    }
}
