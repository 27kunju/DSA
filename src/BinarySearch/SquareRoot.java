package BinarySearch;

public class SquareRoot {

    public static int findSquareRoot(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int low = 1, high = n, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= n / mid) { // mid*mid <= n (avoids overflow)
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans; // integer part of square root
    }

    public static void main(String[] args) {
        int number = 20;
        System.out.println("Square root of " + number + " is: " + findSquareRoot(number));
    }
}
