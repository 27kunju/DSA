package Arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNum {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        int dupNum = getDup(arr);
        int dupNum2 = getDupOpti(arr);
        System.out.println(dupNum + " " + dupNum2);

    }

    public static int getDup(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }

            }
            if (count > 0) {
                return arr[i];
            }
        }

        return n;
    }

    public static int getDupOpti(int[] arr){
        Set<Integer> seen = new HashSet<>();
        for(int n : arr){
            if(seen.contains(n)){
                return n;
            }
            seen.add(n);
        }

        return -1;
    }
}
