package BinarySearch;

public class PeakElement {

    // O(log n) - finds any one peak element
    public static int findOnePeak(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // check if mid is peak
            if (arr[mid] > arr[mid - 1] &&
                     arr[mid] > arr[mid + 1]){
                return mid;
            }

            // if left neighbor is greater, move left
            if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // shouldn't happen
    }

    // O(n) - finds all peaks
    public static java.util.List<Integer> findAllPeaks(int[] arr) {
        java.util.List<Integer> peaks = new java.util.ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if ((i == 0 && arr[i] > arr[i + 1]) ||
                    (i == n - 1 && arr[i] > arr[i - 1]) ||
                    (i > 0 && i < n - 1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1])) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {8, 2, 1, 3, 5, 1};

        System.out.println("One peak in arr1: " + findOnePeak(arr1));
        System.out.println("One peak in arr2: " + findOnePeak(arr2));

        System.out.println("All peaks in arr1: " + findAllPeaks(arr1));
        System.out.println("All peaks in arr2: " + findAllPeaks(arr2));
    }
}
