package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class StreamsConsumedOnce {

    public static void main(String[] args) {

        /*
        Streams can be consumed only once. After a terminal operation like forEach, the stream is closed.
        To perform another operation on the same data, you need to recreate the stream from the original collection
         */
        List<String> names = List.of("IBM", "Infosys", "TCS");

        //create Stream
        Stream<String> stream = names.stream();

        // first terminal operation
        stream.forEach(System.out::println);

        //trying to reuse the same stream
        // IllegalStateException exception is thrown
//        stream.filter(n -> n.startsWith("I"))
//                .forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1,2,4,5);

        int max = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(max);

        List<String> stringList = Arrays.asList("Ashwini", "Tanu","Ammu");

//        String res = stringList.stream().collect(Collectors.joining(","));


        String res = String.join(",", stringList);

        System.out.println(res);

        int[] arr = {1,2,3,4};

        int sum = Arrays.stream(arr).sum();

        List<Integer> nums1 = Arrays.asList(1,2,3,4,5);

        int sum2 = nums1.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);



    }
}
