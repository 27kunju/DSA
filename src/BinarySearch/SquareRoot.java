package BinarySearch;

public class SquareRoot {

    public static int findSquareRoot(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int l = 1, h = n/2, ans = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            long sq = (long) mid * mid;

            if (sq == n) {
                return mid;
            } else if (sq < n) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int number = 20;
        System.out.println("Square root of " + number + " is: " + findSquareRoot(number));
    }
}
