package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Factorialslargenumbers {
    public static List<Integer> factorial(int n) {

        int[] arr = new int[10000]; // stores digits
        arr[0] = 1;
        int size = 1;

        for (int i = 2; i <= n; i++) {
            size = multiply(arr, size, i);
        }

        List<Integer> result = new ArrayList<>();

        // digits are stored in reverse order
        for (int i = size - 1; i >= 0; i--) {
            result.add(arr[i]);
        }

        return result;
    }

    private static int multiply(int[] arr, int size, int num) {
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int prod = arr[i] * num + carry;
            arr[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry > 0) {
            arr[size] = carry % 10;
            carry /= 10;
            size++;
        }

        return size;
    }
}
