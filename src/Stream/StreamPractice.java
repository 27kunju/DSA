package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String[] args) {

        // ------------------ FILTER ------------------
        System.out.println("---- FILTER EXAMPLES ----");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Q1: Even numbers
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens); // [2,4,6,8]

        // Q2: Numbers greater than 4
        List<Integer> gt4 = numbers.stream()
                .filter(n -> n > 4)
                .collect(Collectors.toList());
        System.out.println("Numbers > 4: " + gt4); // [5,6,7,8]

        // Q3: Strings starting with A
        List<String> names = List.of("Alice", "Bob", "Adam", "Charlie");
        List<String> aNames = names.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Names starting with A: " + aNames); // [Alice, Adam]

        // ------------------ MAP ------------------
        System.out.println("---- MAP EXAMPLES ----");
        // Q1: Square numbers
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares); // [1,4,9,16,25,36,49,64]

        // Q2: Convert to string
        List<String> strNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("String numbers: " + strNumbers);

        // Q3: Uppercase names
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);

        // ------------------ DISTINCT ------------------
        System.out.println("---- DISTINCT EXAMPLES ----");
        List<Integer> dupNumbers = List.of(1, 2, 2, 3, 3, 3);
        List<Integer> distinctNumbers = dupNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers); // [1,2,3]

        // ------------------ FLATMAP ------------------
        System.out.println("---- FLATMAP EXAMPLES ----");
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2),
                List.of(3, 4, 5),
                List.of(6)
        );
        List<Integer> flatList = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened list: " + flatList); // [1,2,3,4,5,6]

        // Flatten sentences into words
        List<String> sentences = List.of("hello world", "java streams are fun");
        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());
        System.out.println("Flattened words: " + words);

        // ------------------ SORTED ------------------
        System.out.println("---- SORTED EXAMPLES ----");
        List<String> randomNames = List.of("Alice", "Bob", "Charlie", "Adam");

        // Natural order
        List<String> sortedNames = randomNames.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // Custom order: by length
        List<String> sortedByLength = randomNames.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);

        // Descending order
        List<Integer> descNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Descending numbers: " + descNumbers);

        // ------------------ LIMIT & SKIP ------------------
        System.out.println("---- LIMIT & SKIP ----");
        List<Integer> first3 = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3: " + first3); // [1,2,3]

        List<Integer> skip3 = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Skip first 3: " + skip3); // [4,5,6,7,8]

        // ------------------ REDUCE ------------------
        System.out.println("---- REDUCE EXAMPLES ----");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum); // 36

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product); // 40320

        // ------------------ COLLECTORS ------------------
        System.out.println("---- COLLECTORS EXAMPLES ----");
        // Q1: Collect to Set
        Set<Integer> setNumbers = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("Set: " + setNumbers);

        // Q2: Join strings
        String joinedNames = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined names: " + joinedNames); // Alice, Bob, Adam, Charlie

        // ------------------ GROUPINGBY ------------------
        System.out.println("---- GROUPINGBY EXAMPLES ----");
        List<String> people = List.of("Alice", "Bob", "Adam", "Charlie", "Ann");

        // Group by first letter
        Map<Character, List<String>> groupByFirstLetter = people.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Group by first letter: " + groupByFirstLetter);

        // Group by length
        Map<Integer, List<String>> groupByLength = people.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Group by length: " + groupByLength);

        // Count occurrences
        List<String> namesWithDup = List.of("Alice", "Bob", "Alice", "Bob", "Adam");
        Map<String, Long> countMap = namesWithDup.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Count map: " + countMap); // {Alice=2, Bob=2, Adam=1}

        // ------------------ PARTITIONINGBY ------------------
        System.out.println("---- PARTITIONINGBY EXAMPLES ----");
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitionEvenOdd = numList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partition even/odd: " + partitionEvenOdd);

        // Partition strings by length > 3
        Map<Boolean, List<String>> partitionByLength = people.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println("Partition by length >3: " + partitionByLength);

        // ------------------ COMBINED EXAMPLE ------------------
        System.out.println("---- COMBINED COMPLEX EXAMPLE ----");
        Map<Integer, List<String>> result = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Words grouped by length: " + result);
    }
}

