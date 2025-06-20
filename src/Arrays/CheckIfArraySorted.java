package Arrays;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(isSorted(nums));

    }

    public static boolean isSorted(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }
        return count < 1;
    }
}
