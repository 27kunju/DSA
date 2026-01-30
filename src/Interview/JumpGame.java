package Interview;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is beyond reachable range
            if (i > maxReach) {
                return false;
            }

            // Update the farthest index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit if we can reach the end
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(canJump(nums1)); // true
        System.out.println(canJump(nums2)); // false
    }
}
