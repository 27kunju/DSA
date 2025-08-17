package BinarySearch;

public class PeakElement {

    public static int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is peak
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // If right neighbor is greater → move right
            else if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }

            // Else move left
            else {
                high = mid - 1;
            }
        }
        return -1; // should not happen
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};

        System.out.println("Peak element index in arr1: " + peakElement(arr1));
        System.out.println("Peak element index in arr2: " + peakElement(arr2));
    }
}


