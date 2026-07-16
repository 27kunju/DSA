package Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numberChecker {
    public static void main(String[] args) {


    }

    public List<Integer> getNumbers(List<Integer> nums) {

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {

            Set<Integer> digits = new HashSet<>();

            int temp = num;

            while (temp > 0) {
                digits.add(temp % 10);
                temp /= 10;
            }

            if (digits.contains(1) &&
                    digits.contains(2) &&
                    digits.contains(3)) {
                result.add(num);
            }
        }

        return result;
    }
}
