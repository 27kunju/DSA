package Arrays;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
//        int[] nums  = {1,2,3,4,5};
        System.out.println(isSorted(nums));

    }

    public static boolean isSorted(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;  // Not strictly sorted
            }
        }
        return true;  //
    }
}
