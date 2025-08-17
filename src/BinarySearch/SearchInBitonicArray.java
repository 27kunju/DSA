package BinarySearch;

public class SearchInBitonicArray {

    // Find peak index
    public static int findPeak(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // peak index
            } else if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1; // go right
            } else {
                high = mid - 1; // go left
            }
        }
        return -1;
    }

    // Normal binary search with order flag
    public static int binarySearch(int[] arr, int low, int high, int key, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) return mid;

            if (ascending) {
                if (key < arr[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (key > arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int key) {
        int peak = findPeak(arr);

        // Try left side (increasing)
        int leftAns = binarySearch(arr, 0, peak, key, true);
        if (leftAns != -1) return leftAns;

        // Try right side (decreasing)
        return binarySearch(arr, peak + 1, arr.length - 1, key, false);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 12, 4, 2};
        int[] arr2 = {3, 9, 10, 20, 17, 5, 1};

        System.out.println(search(arr1, 4));   // Output: 4
        System.out.println(search(arr2, 20));  // Output: 3
        System.out.println(search(arr2, 6));   // Output: -1
    }
}
