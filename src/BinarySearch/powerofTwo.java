package BinarySearch;

public class powerofTwo {

    public static boolean isPowerOfTwo(int n) {

        /*
        Why does (n & (n - 1)) == 0 work?

n (power of 2): 1000

n - 1: 0111

AND: 0000

Only powers of two produce 0 after this operation.
         */
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        int n = 8;
        System.out.println(isPowerOfTwo(n));
    }
}
