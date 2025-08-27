package BinarySearch;

public class binarySearchMain {
    public static void main(String[] args) {
        int[] arr = {9, 8, 6, 4, 3, 2, 1};
        int target  = 2;

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int target2 = 2;

        int res = binarySearchDescending(arr, target);
        int res2 = binarySearchAscending(arr2, target2);

        System.out.println("Descending Search Result: " + res);
        System.out.println("Ascending Search Result: " + res2);
    }

    // For ascending sorted array
    public static int binarySearchAscending(int[] arr , int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // found
            } else if ( target < arr[mid]) {
                high = mid-1 ;// move right
            } else {
               low = mid+1; // move left
            }
        }
        return -1; // not found
    }

    // For descending sorted array
    public static int binarySearchDescending(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // found
            } else if (target < arr[mid]) {
               low = mid+1;// move left
            } else {
                high = mid-1; // move right
            }
        }
        return -1; // not found
    }
}
