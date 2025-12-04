package Stream;

import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class duplicates {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "AA");

        Map<String, Long> duplicates =
                list.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting())) // count occurrences
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1) // keep only duplicates
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        ));

        System.out.println(duplicates);  // Output: {AA=2}

    }
}
