package Arrays;

public class PlusOne {

    public static void main(String[] args) {

        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

        int[] result = plusOne(digits);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // case when all digits are 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
