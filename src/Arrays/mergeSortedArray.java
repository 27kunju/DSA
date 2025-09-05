package Arrays;

public class mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,7,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 0;
        for (int num : nums1) {
            if (num != 0) m++;
        }

        int n = nums2.length;

        int i = m - 1;          // last valid index in nums1
        int j = n - 1;          // last index in nums2
        int k = m + n - 1;      // last index in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        for (int r : nums1) {
            System.out.print(r + " ");
        }
    }
}
