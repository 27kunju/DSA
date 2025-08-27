package BinarySearch;

public class NearlySortedSearch {

    public static int searchNearlySorted(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check mid
            if (arr[mid] == target) {
                return mid;
            }
            // Check mid - 1
            if (mid - 1 >= low && arr[mid - 1] == target) {
                return mid - 1;
            }
            // Check mid + 1
            if (mid + 1 <= high && arr[mid + 1] == target) {
                return mid + 1;
            }

            // Adjust search range
            if (target < arr[mid]) {
                high = mid - 2; // skip one index (already checked)
            } else {
                low = mid + 2; // skip one index (already checked)
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;


        //the element which supposed to be in ith position can be present in i, or i+1, i-1
        int index = searchNearlySorted(arr, target);
        System.out.println("Element " + target + " found at index: " + index);
    }
}
