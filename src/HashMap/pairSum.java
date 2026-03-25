package HashMap;

import java.util.*;

public class pairSum {
    public static int[][] pairSum(int[] arr, int target) {

        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : arr) {

            int complement = target - num;

            if (set.contains(complement)) {
                result.add(new int[]{num, complement});
            }

            set.add(num);
        }

        // Convert list to 2D array
        int[][] res = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15, 7 ,3};
        int target = 9;

        int[][] res = pairSum(arr, target);

        for (int[] pair : res) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
