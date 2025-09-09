package Stream;

import java.util.List;

public class StreamVsParallel {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,5);

        //order is preserved
        nums.stream().forEach(System.out::println);
        System.out.println("parallel");

        // order is not preserved in parallel stream
        nums.parallelStream().forEach(System.out::println);
    }
}
