package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueChars {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "orange", "grape");

        Set<Character> uniqueChars = words.stream()
                .flatMap( s->s.chars().mapToObj(c->(char)c))
                .collect(Collectors.toSet());

        String result = uniqueChars.stream().sorted().map(Objects::toString).collect(Collectors.joining());

        System.out.println(result);


    }
}
