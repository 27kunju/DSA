package BinarySearch;

public class MinimumDifferenceElement {

    public static int findClosest(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid];  // exact match
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Now low = index of next greater element
        // high = index of previous smaller element
        if (high < 0) return arr[0];               // all elements > target
        if (low >= arr.length) return arr[arr.length - 1]; // all elements < target

        // Compare differences
        if (Math.abs(arr[low] - target) < Math.abs(arr[high] - target)) {
            return arr[low];
        } else {
            return arr[high];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        int target = 12;

        int ans = findClosest(arr, target);
        System.out.println("Minimum difference element for " + target + " is: " + ans);
    }
}
