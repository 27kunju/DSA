package TwoPointers;

public class LeftRotation {

    // Helper to reverse with two pointers
    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        // Step 1: reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 2: reverse remaining elements
        reverse(arr, k, n - 1);

        // Step 3: reverse whole array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        rotateLeft(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
