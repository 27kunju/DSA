package BinarySearch;

public class CeilInSortedArray {

    public static int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1; // default if no ceil exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return arr[mid]; // exact match is the ceil
            } else if (arr[mid] > x) {
                ans = arr[mid];  // potential ceil
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        int ceil = findCeil(arr, x);
        System.out.println("Ceil of " + x + " is: " + ceil);
    }
}
