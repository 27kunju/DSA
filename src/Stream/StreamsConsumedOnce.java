package Stream;

import java.util.List;
import java.util.stream.Stream;

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
        stream.filter(n -> n.startsWith("I"))
                .forEach(System.out::println);



    }
}
