package BinarySearch;

public class AllocatePages {

    public static boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] > mid) {
                studentCount++;
                pageSum = arr[i];
                if (studentCount > m) return false;
            } else {
                pageSum += arr[i];
            }
        }
        return true;
    }

    public static int allocateBooks(int[] arr, int n, int m) {
        if (m > n) return -1; // not enough books

        int low = Integer.MIN_VALUE, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, m, mid)) {
                res = mid; // possible, try better (smaller max)
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int m = 2;

        System.out.println("Minimum number of pages: " +
                allocateBooks(arr, arr.length, m));
    }
}
