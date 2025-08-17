package BinarySearch;

public class CountOccurrences {

    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1; // search left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1; // search right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0; // element not found
        int last = lastOccurrence(arr, target);
        return (last - first + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 5, 7, 9};
        int target = 4;

        int count = countOccurrences(arr, target);
        System.out.println("Count of " + target + " = " + count);
    }
}
