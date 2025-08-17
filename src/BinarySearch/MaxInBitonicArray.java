package BinarySearch;

public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the maximum
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }

            // If increasing slope → max lies on right
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // Else → max lies on left
            else {
                high = mid - 1;
            }
        }
        return -1; // should never happen
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 12, 4, 2};
        int[] arr2 = {3, 9, 10, 20, 17, 5, 1};

        System.out.println("Max in arr1: " + findMax(arr1)); // 12
        System.out.println("Max in arr2: " + findMax(arr2)); // 20
    }
}
