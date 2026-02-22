package BinarySearch;

/*

duplicate elements are present , still there will be one peak index
 */
public class searchRotatedArray81 {
    // Find pivot (smallest element index)
    public int pivot(int[] nums, int l, int r) {
        while (l < r) {

            // Ignore duplicates from left
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }

            // Ignore duplicates from right
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }

            int mid = l + (r - l) / 2;

            // Right part sorted, pivot could be mid or left
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    // Standard binary search
    public boolean binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;

        int p = pivot(nums, 0, n - 1);

        // Search in left sorted part
        if (binarySearch(nums, 0, p - 1, target)) {
            return true;
        }

        // Search in right sorted part
        return binarySearch(nums, p, n - 1, target);
    }
}
