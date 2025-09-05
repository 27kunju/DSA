package Arrays;

import java.util.ArrayList;
import java.util.List;

public class differenceArrays {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        int[] B = {5,6,7,8};

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            boolean found = false;
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {   // found in B
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.add(A[i]);  // only add if not present in B
            }
        }

        res.forEach(System.out::println);
    }
}
