package Arrays;

import java.util.*;

public class FindPairsForTargetMatch {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 5, 5, 6, 7, 8, 12, 14};
//        int target = 11;

        int[] arr = {2,5,5,11};
        int target = 10;

        List<List<Integer>> result = findPairs2(arr, target);

        System.out.println("Pairs that sum to " + target + ": " + result);
    }

    public static List<List<Integer>> findPairs(int[] arr, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                pairs.add(Arrays.asList(arr[i], arr[j]));
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }

    public static List<List<Integer>> findPairs2(int[] arr, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                pairs.add(Arrays.asList(i, j)); // store indices instead of values
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }
}
