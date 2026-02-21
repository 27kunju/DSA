package BinarySearch;


/*

Clarify → plan → code → explain → dry run → edge cases → complexity
 */
public class searchPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int index = searchIndex2(nums, target);
        System.out.println(index);
    }

    public static int searchIndex(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i < n - 1 && target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return -1;
    }

    public static int searchIndex2(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(target == nums[mid]){
                return mid;
            }else if(target <nums[mid]){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        /*

        At the end of binary search, low points to the first index where nums[i] >= target.

       If target is smaller than the first element, low stays at 0 → insert at start.

       If target is larger than all elements, low moves past the last index → insert at end.
       That’s why returning low always gives the correct insertion index
         */

        return low;
    }
}
