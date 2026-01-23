package Stream;

import java.util.List;
import java.util.Optional;

public class maxNUmber {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4, 5, 6);
        int givenNumber = 15;

        list.stream()
                .map(n -> n * n)          // square each number
                .filter(n -> n > givenNumber) // keep numbers greater than given number
                .forEach(System.out::println);

        Optional<Integer> max =
                list.stream()
                        .map(n -> n * n)
                        .filter(n -> n > givenNumber)
                        .max(Integer::compareTo);

        System.out.println(max.orElse(null));


    }

}
