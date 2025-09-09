package Stream;

import java.util.List;
import java.util.stream.Stream;

public class testLazyExecution {
    public static void main(String[] args) {

        /*
        When we create the stream and add filter(), nothing happens — because intermediate ops are lazy.
        Only when you call findFirst() (a terminal op), the stream starts processing, element by element.
        As soon as it finds "IBM", the stream short-circuits and stops further checks.

        Streams are lazily evaluated, so intermediate operations like map and filter don’t run until a terminal operation is called.
        This helps by avoiding unnecessary computation, supporting short-circuiting operations like findFirst or anyMatch,
        and even making it possible to handle infinite streams with limit. In short, laziness improves performance and
        memory efficiency by doing only the work that’s actually needed.
         */
        List<String> companies = List.of("IBM", "Infosys", "TCS");

        Stream<String> stream = companies.stream().filter(c->{
            System.out.println("filtering" + c);
            return c.startsWith("I");

        });

        System.out.println("before execution");

        String first = stream.findFirst().orElse("");

        System.out.println(first);


    }
}
