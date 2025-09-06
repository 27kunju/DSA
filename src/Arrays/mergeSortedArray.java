package Arrays;

public class mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,8,0,0,0};
        int[] nums2 = {5,6,7};

        // Count how many actual (non-zero) elements nums1 has
        int m = 0;
        for (int num : nums1) {
            if (num != 0) m++;
        }

        int n = nums2.length;

        int i = m - 1;          // pointer for last valid element in nums1
        int j = n - 1;          // pointer for last element in nums2
        int k = m + n - 1;      // pointer for last available space in nums1

        // Merge from the END to avoid overwriting elements of nums1
        // If we merged from the front, elements like "3" in nums1 could get
        // overwritten before being compared. By going backwards, we always
        // place the largest element in the correct position without losing data.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy any remaining elements from nums2 (if any left)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // Print merged sorted array
        for (int r : nums1) {
            System.out.print(r + " ");
        }
    }
}
