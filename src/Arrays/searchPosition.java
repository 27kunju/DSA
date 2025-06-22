package Arrays;

public class searchPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int index = searchIndex(nums, target);
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

        return n;
    }
}
