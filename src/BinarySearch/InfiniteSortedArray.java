package BinarySearch;

public class InfiniteSortedArray {

    // Binary Search
    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // not found
    }

    // Search in Infinite Sorted Array
    public static int searchInfiniteArray(int[] arr, int target) {
        int low = 0, high = 1;

        // Step 1: Expand range exponentially until target <= arr[high]
        while (high < arr.length && arr[high] < target) {
            low = high;
            high = high * 2;
            if (high >= arr.length) high = arr.length - 1; // safety for real arrays
        }

        // Step 2: Apply binary search in [low, high]
        return binarySearch(arr, low, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 9, 10, 13, 15, 20, 40, 50, 60, 70, 80, 90, 100};
        int target = 13;

        int index = searchInfiniteArray(arr, target);
        System.out.println("Element " + target + " found at index: " + index);
    }
}
