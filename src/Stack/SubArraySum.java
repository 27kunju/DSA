package Stack;

import java.util.Stack;

public class SubArraySum {

    // Brute force method — O(n^2)
    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }
        return sum;
    }

    // Optimized method using monotonic stacks — O(n)
    public static int sumSubArray(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1e9 + 7;

        int[] nsl = getNsl(arr, n);
        int[] nsr = getNsr(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - nsl[i];
            long right = nsr[i] - i;

            long totalWays = left * right;
            long totalSum = (arr[i] * totalWays) % MOD;

            sum = (sum + totalSum) % MOD;
        }

        return (int) sum;
    }

    // Get Nearest Smaller to Left (NSL)
    private static int[] getNsl(int[] arr, int n) {
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return nsl;
    }

    // Get Nearest Smaller to Right (NSR)
    private static int[] getNsr(int[] arr, int n) {
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nsr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        System.out.println("Brute Force Sum: " + sumSubarrayMins(arr));
        System.out.println("Optimized Sum: " + sumSubArray(arr));
    }
}
