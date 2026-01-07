package Stream;

import java.util.Arrays;
import java.util.List;

public class mapToIntExample {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        System.out.println(nums.stream().mapToInt(Integer::intValue).sum());
        System.out.println(nums.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println(nums.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println(nums.stream().mapToInt(Integer::intValue).average().getAsDouble());
    }

}
