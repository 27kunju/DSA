package BinarySearch;

public class FloorInSortedArray {

    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1; // default if no floor exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return arr[mid]; // exact match is the floor
            } else if (arr[mid] < x) {
                ans = arr[mid];  // potential floor
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        int floor = findFloor(arr, x);
        System.out.println("Floor of " + x + " is: " + floor);
    }
}
