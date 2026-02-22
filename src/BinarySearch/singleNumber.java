package BinarySearch;

public class singleNumber {
    public int singleNumber(int[] nums) {

        /*
        XOR (^) properties:

        a ^ a = 0
        a ^ 0 = a
        XOR is commutative & associative
        All duplicate numbers cancel out, leaving the unique number.
         */
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;

    }
}
