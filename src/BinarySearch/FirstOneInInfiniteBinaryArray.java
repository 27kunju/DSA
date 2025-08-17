package BinarySearch;

public class FirstOneInInfiniteBinaryArray {

    public static int firstOne(int[] arr) {
        int low = 0, high = 1;

        // Step 1: Expand range until we find a 1
        while (arr[high] == 0) {
            low = high;
            high = high * 2;
            if (high >= arr.length) high = arr.length - 1; // safety for real arrays
        }

        // Step 2: Binary search for first 1
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                ans = mid;   // potential answer
                high = mid - 1; // search left for earlier 1
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}; // simulate infinite array
        int index = firstOne(arr);
        System.out.println("First occurrence of 1 is at index: " + index);
    }
}
