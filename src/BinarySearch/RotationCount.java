package BinarySearch;

public class RotationCount {

    //find the index of of minimum ele
    // minimum ele will be smaller to left and right element
    public static int countRotations(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            // Case 1: already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            // Case 2: Check if mid is minimum
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Case 3: Decide search space
            if (arr[mid] >= arr[low]) {
                // left half sorted → go right
                low = mid + 1;
            } else {
                // right half sorted → go left
                high = mid - 1;
            }
        }
        return -1; // should never happen
    }

    //find minimum in rotated sorted array
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) { // low == high is the answer
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in the right half
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Minimum is in the left half including mid
                high = mid;
            }
        }

        // At the end, low == high pointing to the minimum
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotations = countRotations(arr);

        System.out.println("Array is rotated " + rotations + " times");
        System.out.println(findMin(arr));
    }
}
