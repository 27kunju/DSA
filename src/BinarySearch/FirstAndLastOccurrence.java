package BinarySearch;

public class FirstAndLastOccurrence {

    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;       // possible answer
                high = mid - 1;  // look left
            } else if (target < arr[mid]) {
                high = mid -1;
            } else {
                low  = mid + 1;
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
                ans = mid;      // possible answer
                low = mid + 1;  // look right
            } else if (target < arr[mid]) {
               high = mid-1;
            } else {
               low = low+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 5, 7, 9};
        int target = 4;

        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        System.out.println("First occurrence of " + target + " = " + first);
        System.out.println("Last occurrence of " + target + " = " + last);
    }
}
